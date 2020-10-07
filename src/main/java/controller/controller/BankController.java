package controller.controller;

import entity.*;
import service.AccountService;
import service.BankBranchService;
import service.EmployeeService;
import service.PositionService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class BankController {
    private Scanner scanner;
    private AccountService accountService;
    private BankBranchService bankBranchService;
    private EmployeeService employeeService;

    public void getInformationForCreateAccount() throws ParseException {
        scanner = new Scanner(System.in);
        accountService = new AccountService();
        Customer customer = new Customer();
        bankBranchService = new BankBranchService();
        bankBranchService.showAllBankBranch();
        System.out.print("In which branch do you want to open an account?Enter Branch Code: ");
        int branchCode = scanner.nextInt();
        System.out.print("Enter User Name: ");
        customer.setUserName(scanner.next());
        System.out.print("Enter Password: ");
        customer.setPassword(scanner.next());
        System.out.print("Enter First Name: ");
        customer.setFirstName(scanner.next());
        System.out.print("Enter Last Name: ");
        customer.setLastName(scanner.next());
        System.out.print("Enter National Code: ");
        customer.setNationalCode(scanner.next());
        System.out.print("Enter Birth Date(yyyy/mm/dd): ");
        String dates = scanner.next();
        customer.setBirthDate(new SimpleDateFormat("yyyy/MM/dd").parse(dates));
        accountService.openAnAccount(customer, branchCode);
    }

    public void addEmployeeToBank() throws ParseException {
        scanner = new Scanner(System.in);
        Employee employee = new Employee();
        employeeService = new EmployeeService();
        bankBranchService = new BankBranchService();
        PositionService positionService = new PositionService();
        System.out.print("Enter First Name: ");
        employee.setFirstName(scanner.next());
        System.out.print("Enter Last Name: ");
        employee.setLastName(scanner.next());
        System.out.print("Enter National Code: ");
        employee.setNationalCode(scanner.nextLong());
        System.out.print("Enter Birth Date (yyyy/MM/dd): ");
        String dates = scanner.next();
        employee.setBirthDate(new SimpleDateFormat("yyyy/mm/dd").parse(dates));
        employee.setUserName();
        System.out.println("You're user name is first name + last name + employee code.");
        System.out.print("Enter Password: ");
        employee.setPassword(scanner.next());
        employeeService.showAllEmployee();
        System.out.print("Enter the direct boss code: ");
        Employee directBoss = employeeService.getEmployeeByID(scanner.nextLong());
        employee.setDirectBoss(directBoss);
        positionService.showAllPosition();
        System.out.print("Enter the position id: ");
        Position position = positionService.getPositionByID(scanner.nextLong());
        employee.setPosition(position);
        bankBranchService.showAllBankBranch();
        System.out.print("Enter the branch id: ");
        BankBranch bankBranch = bankBranchService.getBankBranchById(scanner.nextLong());
        employee.setBankBranch(bankBranch);
        employeeService.hiringEmployee(employee);
    }

    public void addBranchBank() {
        BankBranch bankBranch = new BankBranch();
        scanner = new Scanner(System.in);
        employeeService = new EmployeeService();
        System.out.print("Enter Branch Name: ");
        bankBranch.setBranchName(scanner.next());
        System.out.print("Enter Address: ");
        bankBranch.setAddress(scanner.nextLine());
        employeeService.showAllEmployee();
        System.out.print("Enter Boss id: ");
        Employee employee = employeeService.getEmployeeByID(scanner.nextLong());
        bankBranch.setHeadOfBranch(employee);
        bankBranchService.createNewBankBranch(bankBranch);
    }

    //EODAccount = enable or disable account
    public void EODAccount() {
        scanner = new Scanner(System.in);
        List<Account> accountList = accountService.getAllAccount();
        for (Account a : accountList) {
            System.out.println("Account Code: " + a.getId());
            System.out.println("account owner: " + a.getCustomer().getFirstName() + " " + a.getCustomer().getLastName());
            System.out.println("status: " + (a.getStatus() == true ? "Active" : "Deactive"));
        }
        System.out.print("Enter Account code: ");
        Account account = accountService.getAccountByID(scanner.nextLong());
        System.out.println("1 -> enable \t 2 -> disable");
        int temp = scanner.nextInt();
        if (temp == 1) {
            account.setStatus(true);
        } else if (temp == 2) {
            account.setStatus(false);
        }
        accountService.updateStatusAccount(account);
    }
}

package controller.menu;

import controller.ui.CustomerUI;
import controller.ui.EmployeeUI;
import controller.ui.ManagerUI;
import entity.Customer;
import entity.Employee;
import service.AccountService;
import service.CustomerService;
import service.EmployeeService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MainMenu {
    private Scanner scanner;
    private AccountService accountService;
    private CustomerService customerService;
    private EmployeeService employeeService;

    public MainMenu() {
        scanner = new Scanner(System.in);
        accountService = new AccountService();
        customerService = new CustomerService();
        employeeService = new EmployeeService();
    }

    public void getInformationForCreateAccount() throws ParseException {
        Customer customer = new Customer();
        new BankBranchMenu().showAllBankBranch();
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
        System.out.print("Enter Birth Date: ");
        String dates = scanner.next();
        customer.setBirthDate(new SimpleDateFormat("yyyy/MM/dd").parse(dates));
        accountService.openAnAccount(customer, branchCode);
    }

    public void customerLogin() throws Exception {
        System.out.print("User Name: ");
        String userName = scanner.next();
        System.out.print("Password: ");
        String pass = scanner.next();
        Customer customer = customerService.checkValidation(userName, pass);
        if (customer != null) {
            new CustomerUI().dashboard(customer);
        } else {
            System.out.println("User Name Or Password is Incorrect.");
        }
    }

    public void employeeLogin() throws Exception {
        System.out.print("User Name: ");
        String userName = scanner.next();
        System.out.print("Password: ");
        String pass = scanner.next();
        Employee employee = employeeService.checkValidation(userName, pass);
        if (employee.getPosition().getAdministrativePosition().equals("manager")) {
            new ManagerUI().dashboard(employee);
        } else if (employee.getPosition().getAdministrativePosition().equals("manager")){
            new EmployeeUI().dashboard(employee);
        }else {
            System.out.println("User Name Or Password is Incorrect.");
        }
    }
}

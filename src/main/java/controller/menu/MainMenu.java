package controller.menu;

import controller.ui.CustomerUI;
import entity.Customer;
import service.AccountService;
import service.CustomerService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MainMenu {
    private Scanner scanner;
    private AccountService accountService;
    private CustomerService customerService;

    public MainMenu() {
        scanner = new Scanner(System.in);
        accountService = new AccountService();
        customerService = new CustomerService();
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

    public void customerLogin() {
        System.out.print("User Name: ");
        String userName = scanner.next();
        System.out.print("Password: ");
        String pass = scanner.next();
        Customer customer = customerService.checkValidation(userName, pass);
        if (customer != null) {
            new CustomerUI().dashboard(customer);
        } else {
            System.out.println("Invalid Input.");
        }
    }
}

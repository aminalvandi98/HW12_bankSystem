package controller.controller;

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
import java.util.Scanner;

public class MainController {
    private Scanner scanner;
    private AccountService accountService;
    private CustomerService customerService;
    private EmployeeService employeeService;

    public MainController() {
        scanner = new Scanner(System.in);
        accountService = new AccountService();
        customerService = new CustomerService();
        employeeService = new EmployeeService();
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
        } else if (employee.getPosition().getAdministrativePosition().equals("employee")){
            new EmployeeUI().dashboard(employee);
        }else {
            System.out.println("User Name Or Password is Incorrect.");
        }
    }
}

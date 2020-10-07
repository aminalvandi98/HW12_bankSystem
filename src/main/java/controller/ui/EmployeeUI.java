package controller.ui;

import controller.controller.BankController;
import entity.Customer;
import entity.Employee;

import java.util.Scanner;

public class EmployeeUI {
    private BankController bankController;

    public EmployeeUI() {
        bankController = new BankController();
    }
    public void dashboard(Employee employee) throws Exception {
        boolean flag = true;
         while (flag) {
            System.out.println("\t##" + employee.getUserName() + " Welcome##");
            System.out.println("1 -> open an account");
            System.out.println("2 -> enable or disable the account");
            System.out.println("3 -> EXIT");
            int temp = new Scanner(System.in).nextInt();
            switch (temp) {
                case 1:
                    bankController.getInformationForCreateAccount();
                    break;
                case 2:
                    bankController.EODAccount();
                    break;
                case 3:
                    flag = false;
                    break;
            }
        }
    }
}

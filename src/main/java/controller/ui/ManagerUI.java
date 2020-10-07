package controller.ui;

import controller.controller.BankController;
import entity.Customer;
import entity.Employee;

import java.util.Scanner;

public class ManagerUI {
    private BankController bankController;

    public ManagerUI() {
        bankController = new BankController();
    }

    public void dashboard(Employee employee) throws Exception {
        boolean flag = true;
        while (flag) {
            System.out.println("\t##" + employee.getUserName() + " Welcome##");
            System.out.println("1 -> add employee");
            System.out.println("2 -> add bank branch");
            System.out.println("3 -> open an account");
            System.out.println("4 -> enable or disable the account");
            System.out.println("5 -> EXIT");
            int temp = new Scanner(System.in).nextInt();
            switch (temp) {
                case 1:
                    bankController.addEmployeeToBank();
                    break;
                case 2:
                    bankController.addBranchBank();
                    break;
                case 3:
                   bankController.getInformationForCreateAccount();
                    break;
                case 4:
                    bankController.EODAccount();
                    break;
                case 5:
                    flag = false;
                    break;
            }
        }
    }
}

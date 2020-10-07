package controller.ui;

import entity.Customer;
import entity.Employee;

import java.util.Scanner;

public class ManagerUI {
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
                    //...
                    break;
                case 2:
                   //...
                    break;
                case 3:
                    //....
                    break;
                case 4:
                    //...
                    break;
                case 5:
                    flag = false;
                    break;
            }
        }
    }
}

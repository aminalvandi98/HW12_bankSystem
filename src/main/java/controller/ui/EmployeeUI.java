package controller.ui;

import entity.Customer;
import entity.Employee;

import java.util.Scanner;

public class EmployeeUI {
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
                    //...
                    break;
                case 2:
                    //...
                    break;
                case 3:
                    flag = false;
                    break;
            }
        }
    }
}

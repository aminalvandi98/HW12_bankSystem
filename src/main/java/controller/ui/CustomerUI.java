package controller.ui;

import controller.menu.CustomerMenu;
import entity.Customer;

import java.util.Scanner;

public class CustomerUI {
    private CustomerMenu customerMenu;
    public CustomerUI(){
        customerMenu = new CustomerMenu();
    }
    public void dashboard(Customer customer){
        boolean flag = true;
        while (flag){
            System.out.println("\t##" + customer.getUserName() + " Welcome##");
            System.out.println("1 -> increase account balance");
            System.out.println("2 -> view account balance");
            System.out.println("3 -> delete account");
            System.out.println("4 -> card to card");
            System.out.println("5 -> change second password");
            System.out.println("6 -> view card transaction");
            System.out.println("7 -> EXIT");
            int temp = new Scanner(System.in).nextInt();
            switch (temp){
                case 1:
                    customerMenu.increaseBalance(customer);
                    break;
                case 2:
                    //...
                    break;
                case 3:
                    //...
                    break;
                case 4:
                    //...
                    break;
                case 5:
                    //...
                    break;
                case 6:
                    //...
                    break;
                case 7:
                    //...
                    break;
            }
        }
    }
}

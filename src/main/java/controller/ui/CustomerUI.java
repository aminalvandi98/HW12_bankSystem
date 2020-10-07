package controller.ui;

import controller.controller.CustomerController;
import entity.Customer;

import java.util.Scanner;

public class CustomerUI {
    private CustomerController customerMenu;

    public CustomerUI() {
        customerMenu = new CustomerController();
    }

    public void dashboard(Customer customer) throws Exception {
        boolean flag = true;
        while (flag) {
            System.out.println("\t##" + customer.getUserName() + " Welcome##");
            System.out.println("1 -> increase credit card balance");
            System.out.println("2 -> view credit card balance");
            System.out.println("3 -> delete account");
            System.out.println("4 -> card to card");
            System.out.println("5 -> change second password");
            System.out.println("6 -> view card transaction");
            System.out.println("7 -> EXIT");
            int temp = new Scanner(System.in).nextInt();
            switch (temp) {
                case 1:
                    customerMenu.increaseBalance(customer);
                    break;
                case 2:
                    customerMenu.showAccountBalance(customer);
                    break;
                case 3:
                    customerMenu.removeAccount(customer);
                    break;
                case 4:
                    customerMenu.cardToCard(customer);
                    break;
                case 5:
                    customerMenu.changeSecondPass(customer);
                    break;
                case 6:
                    customerMenu.viewTransaction(customer);
                    break;
                case 7:
                    flag = false;
                    break;
            }
        }
    }
}

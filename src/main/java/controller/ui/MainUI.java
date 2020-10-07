package controller.ui;

import controller.controller.MainController;

import java.util.Scanner;

public class MainUI {
    private MainController mainMenu;

    public MainUI() {
        mainMenu = new MainController();
    }

    public void firstPage() throws Exception {
        while (true) {
            System.out.println("1 -> customer login");
            System.out.println("2 -> employee login");
            System.out.println("3 -> EXIT");
            int temp = new Scanner(System.in).nextInt();
            switch (temp) {
                case 1:
                    mainMenu.customerLogin();
                    break;
                case 2:
                    mainMenu.employeeLogin();
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        }
    }
}

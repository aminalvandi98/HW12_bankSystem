package controller.ui;

import controller.menu.MainMenu;

import java.text.ParseException;
import java.util.Scanner;

public class MainUI {
    private MainMenu mainMenu;
    public MainUI(){
        mainMenu = new MainMenu();
    }

    public void firstPage() throws ParseException {
        boolean flag = true;
        while (flag){
            System.out.println("1 -> open an account by customer");
            System.out.println("2 -> customer login");
            System.out.println("3 -> hiring an employee");
            System.out.println("4 -> employee login");
            System.out.println("5 -> EXIT");
            int temp = new Scanner(System.in).nextInt();
            switch (temp){
                case 1:
                    mainMenu.getInformationForCreateAccount();
                    break;
                case 2:
                    mainMenu.customerLogin();
                    break;
                case 3:
                    //...
                    break;
                case 4:
                    //..
                    break;
                case 5:
                   flag = false;
                    break;
            }
        }
    }
}

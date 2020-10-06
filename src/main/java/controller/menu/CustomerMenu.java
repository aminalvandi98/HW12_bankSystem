package controller.menu;

import entity.Account;
import entity.Customer;
import service.AccountService;

import java.util.List;
import java.util.Scanner;

public class CustomerMenu {
    public void increaseBalance(Customer customer) {
        AccountService accountService = new AccountService();
        accountService.showAllAccountByCustomer(customer);
        System.out.print("enter account Id: ");
        Long accountID = new Scanner(System.in).nextLong();
        Account account = accountService.getAccountByID(accountID);
        System.out.print("Enter the amount of balance you want: ");
        Long updateBalance = new Scanner(System.in).nextLong();
        account.setAccountBalance(updateBalance);
        accountService.updateBalance(account);
    }
}

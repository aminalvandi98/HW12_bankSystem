package controller.menu;

import entity.Account;
import entity.Customer;
import entity.Transaction;
import service.AccountService;
import service.TransactionService;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CustomerMenu {
    private AccountService accountService;

    public CustomerMenu() {
        accountService = new AccountService();
    }

    public void increaseBalance(Customer customer) {
        accountService.showAllAccountByCustomer(customer);
        System.out.print("enter account Id: ");
        Long accountID = new Scanner(System.in).nextLong();
        Account account = accountService.getAccountByID(accountID);
        System.out.print("Enter the amount of balance you want: ");
        Long updateBalance = new Scanner(System.in).nextLong();
        account.setAccountBalance(updateBalance);
        Transaction transaction = new Transaction();
        transaction.setAccount(account);
        transaction.setAmount("+" + updateBalance);
        transaction.setDate(new Date());
        transaction.setStatus(true);
        new TransactionService().insert(transaction);
        accountService.updateBalance(account);
    }

    public void showAccountBalance(Customer customer) {
        accountService.showAllAccountByCustomer(customer);
    }

    public void removeAccount(Customer customer) throws Exception {
        accountService.showAllAccountByCustomer(customer);
        System.out.print("enter account Id: ");
        Long accountID = new Scanner(System.in).nextLong();
        accountService.delete(accountID);
    }
}

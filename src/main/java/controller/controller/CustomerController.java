package controller.controller;

import entity.Account;
import entity.CreditCard;
import entity.Customer;
import entity.Transaction;
import repository.entity.CreditCardRepository;
import service.AccountService;
import service.CreditCardService;
import service.TransactionService;

import java.util.Date;
import java.util.Scanner;

public class CustomerController {
    private AccountService accountService;

    public CustomerController() {
        accountService = new AccountService();
    }

    public void increaseBalance(Customer customer) {
        accountService.showAllAccountByCustomer(customer);
        System.out.print("enter account Id: ");
        Long accountID = new Scanner(System.in).nextLong();
        Account account = accountService.getAccountByID(accountID);
        CreditCard creditCard = account.getCreditCard();
        System.out.print("Enter the amount of balance you want: ");
        Long updateBalance = new Scanner(System.in).nextLong();
        if (account.getStatus() == true) {
            creditCard.setCreditCardBalance(updateBalance);
            Transaction transaction = new Transaction();
            transaction.setCreditCard(creditCard);
            transaction.setAmount("+" + updateBalance);
            transaction.setDate(new Date());
            transaction.setStatus(true);
            new TransactionService().insert(transaction);
            accountService.updateBalance(account);

        }

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

    public void cardToCard(Customer customer) {
        Scanner scanner = new Scanner(System.in);
        CreditCardService creditCardService = new CreditCardService();
        int counter = 1;
        while (counter < 4) {
            System.out.println("Enter the source card number:");
            String sourceCardNumber = scanner.next();
            CreditCard sourceCard = creditCardService.checkHasExist(sourceCardNumber);

            System.out.println("Enter the final card number:");
            String finalCardNumber = scanner.next();
            CreditCard finalCard = creditCardService.checkHasExist(finalCardNumber);

            if (sourceCard.getAccount().getStatus() == true && finalCard.getAccount().getStatus() == true) {
                if (sourceCard != null && finalCard != null) {
                    System.out.println("Enter Amount: ");
                    Long amountTransfer = scanner.nextLong();
                    if (sourceCard.getCreditCardBalance() - (amountTransfer + 5000) > 0) {
                        System.out.print("Enter Second Password: ");
                        String secondPass = scanner.next();
                        System.out.print("Enter CVV2: ");
                        Integer cvv2 = scanner.nextInt();
                        System.out.print("Enter Expiration Date: ");
                        String expirationDate = scanner.next();
                        if (sourceCard.getSecondPass().equals(secondPass) &&
                                sourceCard.getCVV2() == cvv2 &&
                                sourceCard.getExpirationDate().equals(expirationDate)) {
                            sourceCard.setCreditCardBalance(sourceCard.getCreditCardBalance() - (amountTransfer + 5000));
                            finalCard.setCreditCardBalance(finalCard.getCreditCardBalance() + (amountTransfer));
                            creditCardService.updateBalance(sourceCard);
                            creditCardService.updateBalance(finalCard);
                            Transaction transactionS = new Transaction();
                            transactionS.setCreditCard(sourceCard);
                            transactionS.setStatus(true);
                            transactionS.setDate(new Date());
                            transactionS.setAmount("-" + amountTransfer);
                            new TransactionService().insert(transactionS);
                            Transaction transactionF = new Transaction();
                            transactionF.setAmount("+" + amountTransfer);
                            transactionF.setDate(new Date());
                            transactionF.setStatus(true);
                            transactionF.setCreditCard(finalCard);
                            new TransactionService().insert(transactionF);
                        } else {
                            System.out.println("Input Invalid.");
                            if (counter == 3) sourceCard.getAccount().setStatus(false);
                            counter++;
                            continue;
                        }

                    } else {
                        System.out.println("Lack of funds.");
                        break;
                    }
                } else {
                    System.out.println("The information entered is incorrect.");
                    break;
                }

            } else {
                System.out.println("The desired cards are blocked.");
                break;
            }

        }
    }

    public void changeSecondPass(Customer customer) {
        accountService.showAllAccountByCustomer(customer);
        System.out.print("enter account Id: ");
        Long accountID = new Scanner(System.in).nextLong();
        Account account = accountService.getAccountByID(accountID);
        CreditCard creditCard = account.getCreditCard();
        System.out.println("Enter second password: ");
        String secondPass = new Scanner(System.in).next();
        creditCard.setSecondPass(secondPass);
        accountService.updateSecondPass(account);
    }

    public void viewTransaction(Customer customer){
        accountService.showAllAccountByCustomer(customer);
        System.out.print("enter account Id: ");
        Long accountID = new Scanner(System.in).nextLong();
        Account account = accountService.getAccountByID(accountID);
        CreditCard creditCard = account.getCreditCard();
        new TransactionService().showAllTransactionByCustomer(creditCard);
    }
}

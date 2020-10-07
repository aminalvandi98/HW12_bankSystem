package service;

import entity.CreditCard;
import entity.Customer;
import entity.Transaction;
import repository.entity.TransactionRepository;

import java.util.List;

public class TransactionService {
    private TransactionRepository transactionRepository;

    public TransactionService() {
        transactionRepository = TransactionRepository.getTransactionRepository();
    }

    public void insert(Transaction transaction) {
        transactionRepository.insert(transaction);
    }

    public void showAllTransactionByCustomer(CreditCard creditCard) {
        List<Transaction> transactionList = transactionRepository.findAllTransactionByCustomer(creditCard);
        for (Transaction t : transactionList){
            System.out.println(t.toString());
        }
    }
}

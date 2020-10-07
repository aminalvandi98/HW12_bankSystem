package service;

import entity.Transaction;
import repository.entity.TransactionRepository;

public class TransactionService {
    private TransactionRepository transactionRepository;
    public TransactionService(){
        transactionRepository = TransactionRepository.getTransactionRepository();
    }
    public void insert(Transaction transaction){
        transactionRepository.insert(transaction);
    }
}

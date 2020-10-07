package repository.entity;

import entity.Transaction;
import repository.base.BaseRepository;

public class TransactionRepository extends BaseRepository<Transaction, Long> {
    private static TransactionRepository transactionRepository;

    private TransactionRepository() {

    }

    public static TransactionRepository getTransactionRepository() {
        if (transactionRepository == null) {
            transactionRepository = new TransactionRepository();
        }
        return transactionRepository;
    }

    @Override
    protected Class<Transaction> getEntityClass() {
        return Transaction.class;
    }
}

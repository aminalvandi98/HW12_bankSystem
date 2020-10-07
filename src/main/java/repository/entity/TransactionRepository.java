package repository.entity;

import entity.Account;
import entity.CreditCard;
import entity.Customer;
import entity.Transaction;
import repository.base.BaseRepository;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

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

    public List<Transaction> findAllTransactionByCustomer(CreditCard creditCard) {
        List<Transaction> transactionList = new ArrayList<>();
        try {
            entityManager.getTransaction().begin();
            TypedQuery<Transaction> query = entityManager.createQuery(
                    "select t from Transaction t where creditCard=:card", Transaction.class);
            query.setParameter("card", creditCard);
            transactionList = query.getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception exception) {
            entityManager.getTransaction().rollback();
            System.out.println(exception.getMessage());
        }
        return transactionList;
    }


    @Override
    protected Class<Transaction> getEntityClass() {
        return Transaction.class;
    }
}

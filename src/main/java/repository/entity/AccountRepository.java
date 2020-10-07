package repository.entity;

import entity.Account;
import entity.CreditCard;
import entity.Customer;
import repository.base.BaseRepository;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository extends BaseRepository<Account, Long> {
    private static AccountRepository accountRepository;

    private AccountRepository() {
    }

    public static AccountRepository getAccountRepository() {
        if (accountRepository == null) {
            accountRepository = new AccountRepository();
        }
        return accountRepository;
    }

    public List<Account> findAllAccountByCustomer(Customer customer) {
        List<Account> accountList = new ArrayList<>();
        try {
            entityManager.getTransaction().begin();
            TypedQuery<Account> query = entityManager.createQuery(
                    "select a from Account a where customer=:customer", Account.class);
            query.setParameter("customer", customer);
            accountList = query.getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception exception) {
            entityManager.getTransaction().rollback();
            System.out.println(exception.getMessage());
        }
        return accountList;
    }


    @Override
    protected Class<Account> getEntityClass() {
        return Account.class;
    }
}

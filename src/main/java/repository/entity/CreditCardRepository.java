package repository.entity;

import entity.Account;
import entity.CreditCard;
import entity.Customer;
import repository.base.BaseRepository;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class CreditCardRepository extends BaseRepository<CreditCard, Long> {
    private static CreditCardRepository creditCardRepository;

    private CreditCardRepository() {
    }

    public static CreditCardRepository getCreditCardRepository() {
        if (creditCardRepository == null) {
           creditCardRepository = new CreditCardRepository();
        }
        return creditCardRepository;
    }

    public CreditCard findCreditCardByCardNumber(String cardNumber){
        CreditCard creditCard = null;
        try {
            entityManager.getTransaction().begin();
            TypedQuery<CreditCard> query = entityManager.createQuery(
                    "select c from CreditCard c where creditCardNumber=:cardNum", CreditCard.class);
            query.setParameter("cardNum", cardNumber);
            creditCard = query.getSingleResult();
            entityManager.getTransaction().commit();
        } catch (Exception exception) {
            entityManager.getTransaction().rollback();
            System.out.println(exception.getMessage());
        }
        return creditCard;
    }


    @Override
    protected Class<CreditCard> getEntityClass() {
        return CreditCard.class;
    }
}

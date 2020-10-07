package repository.entity;

import entity.CreditCard;
import repository.base.BaseRepository;

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

    @Override
    protected Class<CreditCard> getEntityClass() {
        return CreditCard.class;
    }
}

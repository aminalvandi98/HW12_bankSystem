package service;

import entity.CreditCard;
import repository.entity.CreditCardRepository;

import javax.security.auth.login.CredentialException;
import java.text.SimpleDateFormat;
import java.util.Random;

public class CreditCardService {
    private CreditCardRepository creditCardRepository;
    public CreditCardService(){
        creditCardRepository = CreditCardRepository.getCreditCardRepository();
    }
    public CreditCard generateAnCreditCard() {
        CreditCard newCreditCard = new CreditCard();
        newCreditCard.setCreditCardBalance(0L);
        Random random = new Random();
        int temp = random.nextInt(8999) + 1000;
        int temp1 = random.nextInt(8999) + 1000;
        newCreditCard.setCreditCardNumber("60377011" + temp + temp1);
        newCreditCard.setCVV2(temp);
        newCreditCard.setExpirationDate("1400/12");
        newCreditCard.setSecondPass(null);
        newCreditCard.setCreditCardBalance(0L);
        creditCardRepository.insert(newCreditCard);
        return newCreditCard;
    }

    public CreditCard checkHasExist(String cardNumber){
        return creditCardRepository.findCreditCardByCardNumber(cardNumber);
    }
    public CreditCard updateBalance(CreditCard creditCard){
        CreditCard creditCard1 = creditCardRepository.update(creditCard);
        if (creditCard1 != null){
            System.out.println("Card balance successfully updated.");
        }
        return creditCard1;
    }
}

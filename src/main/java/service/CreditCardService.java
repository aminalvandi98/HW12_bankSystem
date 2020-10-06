package service;

import entity.CreditCard;

import java.text.SimpleDateFormat;
import java.util.Random;

public class CreditCardService {
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
        return newCreditCard;
    }
}

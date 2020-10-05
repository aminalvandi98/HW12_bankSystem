package entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "credit_card")
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false, updatable = false)
    private Long id;

    @Column(name = "credit_card_number",unique = true,nullable = false,length = 16)
    private String creditCardNumber;

    @Column(name = "cvv2",unique = true,nullable = false)
    private Integer CVV2;

    @Column(name = "expiration_date",nullable = false)
    private Date expirationDate;

    @Column(name = "second_password")
    private String secondPass;

    @Column(name = "balance")
    private Long creditCardBalance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public Integer getCVV2() {
        return CVV2;
    }

    public void setCVV2(Integer CVV2) {
        this.CVV2 = CVV2;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getSecondPass() {
        return secondPass;
    }

    public void setSecondPass(String secondPass) {
        this.secondPass = secondPass;
    }

    public Long getCreditCardBalance() {
        return creditCardBalance;
    }

    public void setCreditCardBalance(Long creditCardBalance) {
        this.creditCardBalance = creditCardBalance;
    }
}

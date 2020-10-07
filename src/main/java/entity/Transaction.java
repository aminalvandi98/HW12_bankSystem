package entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, updatable = false)
    private Long id;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "date")
    private Date date;

    @Column(name = "amount")
    private String amount;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_credit_card")
    private CreditCard creditCard;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", status=" + (status == true ? "successful" : "unsuccessful") +
                ", date=" + date +
                ", amount='" + amount + '\'' +
                ", creditCard=" + creditCard +
                '}';
    }
}

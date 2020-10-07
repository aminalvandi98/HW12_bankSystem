package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, updatable = false)
    private Long id;

    @Column(name = "account_number", unique = true, nullable = false)
    private Long accountNumber;

    @Column(name = "status",columnDefinition = "TINYINT")
    private Boolean status;

    @OneToOne
    @JoinColumn (name = "fk_credit_card")
    private CreditCard creditCard;

    @ManyToOne
    @JoinColumn(name = "fk_bank_branch")
    private BankBranch bankBranch;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_customer")
    private Customer customer;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public BankBranch getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(BankBranch bankBranch) {
        this.bankBranch = bankBranch;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountNumber=" + accountNumber +
                ", status=" + status +
                ", creditCard=" + creditCard +
                ", bankBranch=" + bankBranch +
                ", customer=" + customer +
                '}';
    }
}

package entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Random;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, updatable = false)
    private Long id;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "national_code", unique = true, nullable = false)
    private Long nationalCode;

    @Column(name = "birth_date")
    private Date birthDate;

    @OneToOne
    @JoinColumn(name = "direct_boss",nullable = true)
    private Employee directBoss;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "employee_position")
    private Position position;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private BankBranch bankBranch;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(Long nationalCode) {
        this.nationalCode = nationalCode;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Employee getDirectBoss() {
        return directBoss;
    }

    public void setDirectBoss(Employee directBoss) {
        this.directBoss = directBoss;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName() {
        this.userName = this.firstName + this.lastName + new Random().nextInt(20);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public BankBranch getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(BankBranch bankBranch) {
        this.bankBranch = bankBranch;
    }
}

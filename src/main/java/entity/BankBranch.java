package entity;

import org.hibernate.annotations.JoinColumnOrFormula;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "bank_branch")
public class BankBranch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, updatable = false)
    private Long id;

    @Column(name = "branch_name", nullable = false)
    private String branchName;

    @Column(name = "address", nullable = false)
    private String address;

    @OneToOne
    @JoinColumn(name = "head_of_branch")
    private Employee headOfBranch;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Employee getHeadOfBranch() {
        return headOfBranch;
    }

    public void setHeadOfBranch(Employee headOfBranch) {
        this.headOfBranch = headOfBranch;
    }


    @Override
    public String toString() {
        return "BankBranch{" +
                "Branch Code=" + id +
                ", branchName='" + branchName + '\'' +
                ", address='" + address + '\'' +
                ", headOfBranch=" + headOfBranch.getFirstName() + " " + headOfBranch.getLastName() +
                '}';
    }

}

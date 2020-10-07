package service;

import entity.BankBranch;
import entity.Employee;
import repository.entity.BankBranchRepository;

import java.util.List;

public class BankBranchService {
    private BankBranchRepository bankBranchRepository;

    public BankBranchService() {
        bankBranchRepository = BankBranchRepository.getBankBranchR();
    }

    public List<BankBranch> getAllBankBranch() {
        return bankBranchRepository.findAll();
    }

    public BankBranch getBankBranchById(Long id) {
        return bankBranchRepository.findByID(id);
    }

    public void showAllBankBranch() {
        List<BankBranch> branchList = getAllBankBranch();
        if (branchList.size() == 0) {
            BankBranch bankBranch = new BankBranch();
            bankBranch.setBranchName("Center Branch");
            bankBranch.setAddress("IR,TEHRAN");
            bankBranch.setHeadOfBranch(null);
            bankBranchRepository.insert(bankBranch);
            branchList = getAllBankBranch();
        }
        for (BankBranch b : branchList) {
            System.out.println(b.toString());
        }
    }

    public void createNewBankBranch(BankBranch bankBranch) {
        if (bankBranchRepository.insert(bankBranch) != null) {
            System.out.println("The bank branch was created successfully.");
        }
    }
}

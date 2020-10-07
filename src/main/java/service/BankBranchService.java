package service;

import entity.BankBranch;
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
}

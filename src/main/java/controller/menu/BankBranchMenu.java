package controller.menu;

import entity.BankBranch;
import service.BankBranchService;

import java.util.List;

public class BankBranchMenu {
    private BankBranchService bankBranchService;

    public BankBranchMenu() {
        bankBranchService = new BankBranchService();
    }

    public void showAllBankBranch() {
        List<BankBranch> branchList = bankBranchService.getAllBankBranch();
        for (BankBranch b:branchList){
            b.toString();
        }
    }
}

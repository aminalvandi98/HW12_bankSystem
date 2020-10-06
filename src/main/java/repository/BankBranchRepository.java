package repository;

import entity.BankBranch;

public class BankBranchRepository extends BaseRepository<BankBranch, Long> {
    private static BankBranchRepository bankBranchRepository;

    private BankBranchRepository() {
    }

    public static BankBranchRepository getBankBranchR() {
        if (bankBranchRepository == null) {
            bankBranchRepository = new BankBranchRepository();
        }
        return bankBranchRepository;
    }

    @Override
    protected Class<BankBranch> getEntityClass() {
        return BankBranch.class;
    }
}

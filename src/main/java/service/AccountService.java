package service;

import entity.Account;
import entity.BankBranch;
import entity.CreditCard;
import entity.Customer;
import repository.AccountRepository;

import java.util.List;
import java.util.Random;

public class AccountService {
    private AccountRepository accountRepository;

    public AccountService() {
        accountRepository = AccountRepository.getAccountRepository();
    }

    public void openAnAccount(Customer customer, int branchCode) {
        Account account = new Account();
        account.setCustomer(customer);
        account.setAccountBalance(0L);
        Random random = new Random();
        int randomNumber = random.nextInt(1000);
        account.setAccountNumber((long) (randomNumber + 10000));
        account.setStatus(true);
        BankBranch bankBranch = new BankBranchService().getBankBranchById((long) branchCode);
        account.setBankBranch(bankBranch);
        account.setCreditCard(new CreditCardService().generateAnCreditCard());
        accountRepository.insert(account);
    }

    public List<Account> getAllAccountByCustomer(Customer customer) {
        return accountRepository.findAllAccountByCustomer(customer);
    }

    public Account getAccountByID(Long id) {
        return accountRepository.findByID(id);
    }

    public void showAllAccountByCustomer(Customer customer){
        List<Account> accountList= getAllAccountByCustomer(customer);
        for (Account a: accountList)
        {
            System.out.println(a);
        }
    }
    public void updateBalance(Account account){
        accountRepository.update(account);
    }

}

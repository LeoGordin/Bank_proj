package BankProject.service;

import BankProject.domain.entity.Account;
import BankProject.domain.entity.Transaction;
import BankProject.repository.AccountRepository;
import BankProject.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class AccountService implements BankProject.service.interfaces.AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account findById(UUID id) {
        return accountRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public void createAccount(Account account) {
        accountRepository.save(account);
    }

    @Override
    public void deleteAccount(Account account) {
        accountRepository.delete(account);
    }

    @Override
    public void deleteAccountById(UUID id) {
        accountRepository.deleteById(id);
    }

    @Override
    public void updateAccount(Account account) {
        accountRepository.saveAndFlush(account);
    }

    @Override
    public BigDecimal getBalance(Account account) {
        return account.getBalance();
    }

    @Override
    public void deposit(Account account, BigDecimal amount) {

        int type = 1;

        BigDecimal balance = account.getBalance();
        balance = balance.add(amount);
        account.setBalance(balance);
        accountRepository.save(account);
        transactionRepository.save(
                new Transaction()
        );
    }

    @Override
    public void withdraw(Account account, BigDecimal amount) {

        int type = 2;

        BigDecimal balance = account.getBalance();
        if (balance.compareTo(amount) < 0) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        balance = balance.subtract(amount);
        account.setBalance(balance);

        accountRepository.save(account);
        transactionRepository.save(
                new Transaction(
                )
        );
    }

    @Override
    public void transfer(Account from, Account to, BigDecimal amount) {

        int type = 3;

        BigDecimal fromBalance = from.getBalance();
        BigDecimal toBalance = to.getBalance();

        if (fromBalance.compareTo(amount) < 0) {
            throw new IllegalArgumentException("Insufficient funds");
        }

        from.setBalance(fromBalance.subtract(amount));
        to.setBalance(toBalance.add(amount));

        accountRepository.save(from);

        accountRepository.save(to);

        transactionRepository.save(
                new Transaction()
        );
    }

}

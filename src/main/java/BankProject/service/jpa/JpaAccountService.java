package BankProject.service.jpa;

import BankProject.domain.entity.jpa.JpaAccount;
import BankProject.domain.entity.jpa.JpaTransaction;
import BankProject.repository.AccountRepository;
import BankProject.repository.TransactionRepository;
import BankProject.service.interfaces.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class JpaAccountService implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public List<JpaAccount> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public List<JpaAccount> findByClientId(int clientId) {
        List<JpaAccount> accounts = new ArrayList<>();
        accountRepository.findAll().stream()
                .filter(account -> account.getClientId() == clientId)
                .forEach(accounts::add);
        return accounts;
    }

    @Override
    public JpaAccount findById(UUID id) {
        return accountRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public void createAccount(JpaAccount account) {
        accountRepository.save(account);
    }

    @Override
    public void deleteAccount(JpaAccount account) {
        accountRepository.delete(account);
    }

    @Override
    public void updateAccount(JpaAccount account) {
        accountRepository.saveAndFlush(account);
    }

    @Override
    public BigDecimal getBalance(JpaAccount account) {
        return account.getBalance();
    }

    @Override
    public void deposit(JpaAccount account, BigDecimal amount) {

        BigDecimal balance = account.getBalance();
        balance = balance.add(amount);
        account.setBalance(balance);
        JpaTransaction transaction = new JpaTransaction();
        accountRepository.save(account);
        transactionRepository.save(transaction);
    }

    @Override
    public void withdraw(JpaAccount account, BigDecimal amount) {

        BigDecimal balance = account.getBalance();
        if (balance.compareTo(amount) < 0) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        balance = balance.subtract(amount);
        account.setBalance(balance);

        JpaTransaction transaction = new JpaTransaction();

        accountRepository.save(account);
        transactionRepository.save(transaction);

    }

    @Override
    public void transfer(JpaAccount from, JpaAccount to, BigDecimal amount) {

        if (from.getId().equals(to.getId())) {
            throw new IllegalArgumentException("Cannot transfer to the same account");
        }

        BigDecimal fromBalance = from.getBalance();
        if (fromBalance.compareTo(amount) < 0) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        fromBalance = fromBalance.subtract(amount);
        from.setBalance(fromBalance);
        accountRepository.save(from);

        BigDecimal toBalance = to.getBalance();
        toBalance = toBalance.add(amount);
        to.setBalance(toBalance);
        accountRepository.save(to);

        JpaTransaction transaction = new JpaTransaction();

        transactionRepository.save(transaction);

    }
}

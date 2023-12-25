package BankProject.service.jpa;

import BankProject.domain.entity.jpa.JpaAccount;
import BankProject.domain.entity.jpa.JpaClient;
import BankProject.domain.entity.jpa.JpaTransaction;
import BankProject.repository.AccountRepository;
import BankProject.repository.ClientRepository;
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

    @Autowired
    ClientRepository clientRepository;

    @Override
    public List<JpaAccount> findAll() {
        return accountRepository.findAll();
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

        int type = 1;

        BigDecimal balance = account.getBalance();
        balance = balance.add(amount);
        account.setBalance(balance);
        accountRepository.save(account);
        transactionRepository.save(
                new JpaTransaction(
                )
        );
    }

    @Override
    public void withdraw(JpaAccount account, BigDecimal amount) {

        int type = 2;

        BigDecimal balance = account.getBalance();
        if (balance.compareTo(amount) < 0) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        balance = balance.subtract(amount);
        account.setBalance(balance);

        accountRepository.save(account);
        transactionRepository.save(
                new JpaTransaction(
                )
        );
    }

    @Override
    public void transfer(JpaAccount from, JpaAccount to, BigDecimal amount) {

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
                new JpaTransaction()
        );
    }

    }

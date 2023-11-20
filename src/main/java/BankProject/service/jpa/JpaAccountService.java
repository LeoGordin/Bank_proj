package BankProject.service.jpa;

import BankProject.domain.entity.interfaces.Transaction;
import BankProject.domain.entity.jpa.JpaAccount;
import BankProject.domain.entity.jpa.JpaTransaction;
import BankProject.repository.AccountRepository;
import BankProject.repository.TransactionRepository;
import BankProject.service.interfaces.AccountService;
import jakarta.validation.constraints.NotNull;
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

    // TODO: implement this
    @Override
    public List<JpaAccount> findByClientId(int clientId) {
        List<JpaAccount> accounts = new ArrayList<>();
        accounts.add(accountRepository.findAll().stream()
                .filter(account -> account.getClientId() == clientId).findFirst().get());
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
    public BigDecimal getBalance(@NotNull JpaAccount account) {
        return account.getBalance();
    }

    @Override
    public void deposit(JpaAccount account, BigDecimal amount) {

        BigDecimal balance = account.getBalance();
        balance = balance.add(amount);
        account.setBalance(balance);
        accountRepository.save(account);
        transactionRepository.save(new JpaTransaction(
                UUID.randomUUID(),
                account.getId(),
                null,
                0,
                amount,
                new Timestamp(System.currentTimeMillis()),
                String.format("Deposit of %b to %s", amount, account.getName())
        ));

    }

    @Override
    public void withdraw(JpaAccount account, BigDecimal amount) {

        BigDecimal balance = account.getBalance();
        balance = balance.subtract(amount);
        account.setBalance(balance);
        accountRepository.save(account);
        transactionRepository.save(new JpaTransaction(
                UUID.randomUUID(),
                account.getId(),
                null,
                0,
                amount,
                new Timestamp(System.currentTimeMillis()),
                String.format("Withdrawal of %b from %s", amount, account.getName())
        ));

    }

    @Override
    public void transfer(JpaAccount from, JpaAccount to, BigDecimal amount) {

        BigDecimal fromBalance = from.getBalance();
        fromBalance = fromBalance.subtract(amount);
        from.setBalance(fromBalance);
        accountRepository.save(from);

        BigDecimal toBalance = to.getBalance();
        toBalance = toBalance.add(amount);
        to.setBalance(toBalance);
        accountRepository.save(to);

        transactionRepository.save(new JpaTransaction(
                UUID.randomUUID(),
                from.getId(),
                to.getId(),
                0,
                amount,
                new Timestamp(System.currentTimeMillis()),
                String.format("Transfer of %b from %s to %s", amount, from.getName(), to.getName())
        ));

    }
}

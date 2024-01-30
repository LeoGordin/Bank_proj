package BankProject.service.interfaces;

import BankProject.domain.entity.Account;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;


public interface AccountService {

    List<Account> findAll();

    Account findById(UUID id);

    void createAccount(Account account);

    void deleteAccount(Account account);

    void deleteAccountById(UUID id);

    void updateAccount(Account account);

    BigDecimal getBalance(Account account);

    void deposit(Account account, BigDecimal amount);

    void withdraw(Account account, BigDecimal amount);

    void transfer(Account from, Account to, BigDecimal amount);


}

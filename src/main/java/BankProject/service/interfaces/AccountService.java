package BankProject.service.interfaces;

import BankProject.domain.entity.interfaces.Transaction;
import BankProject.domain.entity.jpa.JpaAccount;
import BankProject.domain.entity.jpa.JpaTransaction;

import java.math.BigDecimal;
import java.security.Timestamp;
import java.util.List;
import java.util.UUID;


public interface AccountService {

    List<JpaAccount> findAll();

    List<JpaAccount> findByClientId(int clientId);

    JpaAccount findById(UUID id);

    void createAccount(JpaAccount account);

    void deleteAccount(JpaAccount account);

    void updateAccount(JpaAccount account);

    BigDecimal getBalance(JpaAccount account);

    void deposit(JpaAccount account, BigDecimal amount);

    void withdraw(JpaAccount account, BigDecimal amount);

    void transfer(JpaAccount from, JpaAccount to, BigDecimal amount);


}

package BankProject.service.interfaces;

import BankProject.domain.entity.jpa.JpaTransaction;

import java.util.List;
import java.util.UUID;

public interface TransactionService {

    List<JpaTransaction> findAll();

    JpaTransaction getById(UUID id);

    void createTransaction(JpaTransaction transaction);

    void deleteTransaction(JpaTransaction transaction);

    void updateTransaction(JpaTransaction transaction);

    List<JpaTransaction> getTransactionsByAccount(UUID accountId, java.sql.Timestamp from, java.sql.Timestamp to);

    List<JpaTransaction> getTransactionsByClient(int clientId, java.sql.Timestamp from, java.sql.Timestamp to);
}

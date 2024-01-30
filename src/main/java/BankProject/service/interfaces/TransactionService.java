package BankProject.service.interfaces;

import BankProject.domain.entity.Client;
import BankProject.domain.entity.Transaction;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

public interface TransactionService {

    List<Transaction> findAll();

    Transaction getById(UUID id);

    void createTransaction(Transaction transaction);

    void deleteTransactionbyId(UUID id);

    List<Transaction> getTransactionsByAccount(UUID accountId, java.sql.Timestamp from, java.sql.Timestamp to);

    List<Transaction> getTransactionsByClient(Client client, java.sql.Timestamp from, java.sql.Timestamp to);

    List<Transaction> getTransactionsByTime(Timestamp from, Timestamp to);
}

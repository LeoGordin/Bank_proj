package BankProject.service.interfaces;

import BankProject.domain.entity.Client;
import BankProject.domain.entity.Transaction;
import BankProject.domain.entity.dto.ClientDTO;
import BankProject.domain.entity.dto.TransactionDTO;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

public interface TransactionService {

    List<TransactionDTO> findAll();

    TransactionDTO getById(UUID id);

    void createTransaction(TransactionDTO transaction);

    void deleteTransactionById(UUID id);

    List<TransactionDTO> getTransactionsByAccount(UUID accountId, java.sql.Timestamp from, java.sql.Timestamp to);

    List<TransactionDTO> getTransactionsByClientId(int clientId, java.sql.Timestamp from, java.sql.Timestamp to);

    List<TransactionDTO> getTransactionsByTime(Timestamp from, Timestamp to);
}

package BankProject.service.interfaces;

import BankProject.domain.entity.dto.TransactionDTO;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

public interface TransactionServiceInterface {

    List<TransactionDTO> findAll();

    TransactionDTO getById(int id);

    void createTransaction(TransactionDTO transaction);

    void deleteTransactionById(int id);

    List<TransactionDTO> getTransactionsByAccountID(int accountId, Timestamp from, Timestamp to);

    List<TransactionDTO> getTransactionsByClientId(int clientId, java.sql.Timestamp from, java.sql.Timestamp to);

    List<TransactionDTO> getTransactionsByTime(Timestamp from, Timestamp to);
}

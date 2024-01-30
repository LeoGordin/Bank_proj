package BankProject.repository;

import BankProject.domain.entity.Client;
import BankProject.domain.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {

    List<Transaction> findByCreatedAtAndCreatedAt(Timestamp from, Timestamp to);

    List<Transaction> findByCreditAccountIdAndCreatedAtAndCreatedAt(UUID CreditAccountId, Timestamp from, Timestamp to);

    List<Transaction> findByClientAndCreatedAtAndCreatedAt(Client client, Timestamp from, Timestamp to);

    void deleteById(UUID id);


}

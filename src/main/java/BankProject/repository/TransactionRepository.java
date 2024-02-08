package BankProject.repository;

import BankProject.domain.entity.Client;
import BankProject.domain.entity.Transaction;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    @Query(value = "SELECT * FROM transaction WHERE created_at BETWEEN ?1 AND ?2", nativeQuery = true)
    List<Transaction> findByCreatedAtAndCreatedAt(Timestamp from, Timestamp to);

    @Query(value = "SELECT * FROM transaction WHERE credit_account_id = ?1 AND created_at BETWEEN ?2 AND ?3", nativeQuery = true)
    List<Transaction> findByCreditAccountIdAndCreatedAtAndCreatedAt(int creditAccountId, Timestamp from, Timestamp to);

    @Query(value = "SELECT * FROM transaction WHERE client_id = ?1 AND created_at BETWEEN ?2 AND ?3", nativeQuery = true)
    List<Transaction> findByClientIdAndCreatedAtAndCreatedAt(int clientId, Timestamp from, Timestamp to);

    @Query(value = "SELECT * FROM transaction WHERE id = ?1", nativeQuery = true)
    void deleteById(@NotNull int id);


}

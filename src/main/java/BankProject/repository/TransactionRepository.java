package BankProject.repository;

import BankProject.domain.entity.jpa.JpaTransaction;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;
// TODO
public interface TransactionRepository extends JpaRepository<JpaTransaction, UUID> {
    @Query("select t from transactions t where t.clientId = ?1 and t.createdAt between ?2 and ?3")
    List<JpaTransaction> findByClientIdAndCreatedAt(int clientId, Timestamp from, Timestamp to);
    @Query("select t from transactions t where t.creditAccountId = ?1 and t.createdAt between ?2 and ?3")
    List<JpaTransaction> findByCreditAccountIdAndCreatedAt(UUID creditAccountId, Timestamp from, Timestamp to);
}

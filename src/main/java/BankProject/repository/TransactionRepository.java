package BankProject.repository;

import BankProject.domain.entity.jpa.JpaTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransactionRepository extends JpaRepository<JpaTransaction, UUID> {
}

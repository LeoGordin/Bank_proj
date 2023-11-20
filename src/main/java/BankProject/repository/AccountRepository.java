package BankProject.repository;

import BankProject.domain.entity.jpa.JpaAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<JpaAccount, UUID> {
}

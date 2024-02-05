package BankProject.repository;

import BankProject.domain.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {

    @Query(value = "SELECT * FROM account WHERE id = ?1", nativeQuery = true)
    public void getAccountById(UUID id);

    @Query(value = "DELETE FROM account WHERE id = ?1", nativeQuery = true)
    public void deleteAccountById(UUID id);
}

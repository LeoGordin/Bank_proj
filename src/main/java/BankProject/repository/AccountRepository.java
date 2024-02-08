package BankProject.repository;

import BankProject.domain.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, Integer> {

    @Query(value = "SELECT * FROM account WHERE id = ?1", nativeQuery = true)
    public Account getById(int id);

    @Query(value = "DELETE FROM account WHERE id = ?1", nativeQuery = true)
    public void deleteAccountById(int id);
}

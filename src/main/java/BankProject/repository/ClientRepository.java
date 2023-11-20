package BankProject.repository;

import BankProject.domain.entity.jpa.JpaClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<JpaClient, Integer> {
}

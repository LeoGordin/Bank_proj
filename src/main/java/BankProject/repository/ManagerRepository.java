package BankProject.repository;

import BankProject.domain.entity.jpa.JpaManager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<JpaManager, Integer> {
}

package BankProject.repository;

import BankProject.domain.entity.Agreement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgreementRepository extends JpaRepository<Agreement, Integer> {

}

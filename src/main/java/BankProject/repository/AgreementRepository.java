package BankProject.repository;

import BankProject.domain.entity.interfaces.Agreement;
import BankProject.domain.entity.jpa.JpaAgreement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AgreementRepository extends JpaRepository<JpaAgreement, Integer> {

}

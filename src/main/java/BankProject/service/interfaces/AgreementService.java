package BankProject.service.interfaces;

import BankProject.domain.entity.interfaces.Agreement;
import BankProject.domain.entity.jpa.JpaAgreement;
import BankProject.repository.AgreementRepository;

import java.util.List;
import java.util.UUID;

public interface AgreementService {

    List<JpaAgreement> getAll();

    List<JpaAgreement> getByClientId(int clientId);

    JpaAgreement getById(UUID id);

    void removeById(UUID id);

    void createAgreement(JpaAgreement agreement);

    void removeAgreement(JpaAgreement agreement);

    void updateAgreement(JpaAgreement agreement);
    
}

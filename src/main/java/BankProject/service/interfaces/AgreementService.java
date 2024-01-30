package BankProject.service.interfaces;

import BankProject.domain.entity.Agreement;

import java.util.List;
import java.util.UUID;

public interface AgreementService {

    List<Agreement> findAll();

    List<Agreement> getByClientId(int clientId);

    Agreement getById(UUID id);

    void removeById(UUID id);

    void createAgreement(Agreement agreement);

    void removeAgreement(Agreement agreement);

    void updateAgreement(Agreement agreement);
    
}

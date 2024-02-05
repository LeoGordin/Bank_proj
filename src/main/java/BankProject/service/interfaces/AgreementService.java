package BankProject.service.interfaces;

import BankProject.domain.entity.Agreement;
import BankProject.domain.entity.dto.AgreementDTO;

import java.util.List;
import java.util.UUID;

public interface AgreementService {

    List<AgreementDTO> findAll();

    List<AgreementDTO> getByClientId(int clientId);

    AgreementDTO getById(UUID id);

    void removeById(UUID id);

    void createAgreement(AgreementDTO agreement);

    void removeAgreement(AgreementDTO agreement);

//    void updateAgreement(
//            UUID agreementId,
//            Account account,
//            Product product,
//            Client client,
//            float interestRate,
//            AgreementStatus status,
//            BigDecimal sum,
//            Currency currency,
//            Timestamp createdAt,
//            Timestamp updatedAt
//    );

}

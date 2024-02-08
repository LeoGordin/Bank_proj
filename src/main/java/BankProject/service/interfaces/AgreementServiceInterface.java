package BankProject.service.interfaces;

import BankProject.domain.entity.dto.AgreementDTO;

import java.util.List;
import java.util.UUID;

public interface AgreementServiceInterface {

    List<AgreementDTO> findAll();

    List<AgreementDTO> getByClientId(int clientId);

    AgreementDTO getById(int id);

    void deleteById(int id);

    void saveAgreement(AgreementDTO agreement);

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

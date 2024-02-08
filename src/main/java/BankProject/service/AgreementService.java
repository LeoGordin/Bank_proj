package BankProject.service;

import BankProject.domain.entity.Agreement;
import BankProject.domain.entity.dto.AgreementDTO;
import BankProject.repository.AgreementRepository;
import BankProject.service.interfaces.AgreementServiceInterface;
import BankProject.service.mapping.AgreementMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AgreementService implements AgreementServiceInterface {

    @Autowired
    AgreementRepository agreementRepository;

    @Autowired
    AgreementMappingService agreementMappingService;

    @Override
    public List<AgreementDTO> findAll() {
        return agreementRepository.findAll()
                .stream()
                .map(agreementMappingService::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public List<AgreementDTO> getByClientId(int clientId) {

        List<Agreement> agreements = agreementRepository.findAll().stream()
                .filter(agreement -> agreement.getClientId() == clientId).collect(Collectors.toList());

        if (agreements.isEmpty()) {
            throw new NoSuchElementException();
        }

        return agreements
                .stream()
                .map(agreementMappingService::mapToDTO)
                .collect(Collectors.toList());

    }

    @Override
    public AgreementDTO getById(int id) {
        Agreement foundAgreement = agreementRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return agreementMappingService.mapToDTO(foundAgreement);
    }

    @Override
    public void deleteById(int id) {

        agreementRepository.deleteById(id);
    }

    @Override
    public void saveAgreement(AgreementDTO agreement) {

        agreementRepository.save(agreementMappingService.mapToEntity(agreement));
    }

    @Override
    public void removeAgreement(AgreementDTO agreement) {

        agreementRepository.delete(agreementMappingService.mapToEntity(agreement));
    }


}

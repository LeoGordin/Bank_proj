package BankProject.service;

import BankProject.domain.entity.Agreement;
import BankProject.repository.AgreementRepository;
import BankProject.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AgreementService implements BankProject.service.interfaces.AgreementService {

    @Autowired
    private AgreementRepository agreementRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Agreement> findAll() {
        return agreementRepository.findAll();
    }

    @Override
    public List<Agreement> getByClientId(int clientId) {

        List <Agreement> agreements = agreementRepository.findAll().stream()
                .filter(agreement -> agreement.getClientId() == clientId).collect(Collectors.toList());

        if (agreements.isEmpty()) {
            throw new NoSuchElementException();
        }

        return agreements;

    }
    @Override
    public Agreement getById(UUID id) {
        return agreementRepository.findAll().stream()
                .filter(agreement -> agreement.getId().equals(id)).findFirst().get();
    }

    @Override
    public void removeById(UUID id) {
        agreementRepository.delete(findAll().stream()
                .filter(agreement -> agreement.getId().equals(id)).findFirst().get());
    }

    @Override
    public void createAgreement(Agreement agreement) {
        agreementRepository.save(agreement);
    }

    @Override
    public void removeAgreement(Agreement agreement) {
        agreementRepository.delete(agreement);
    }

    @Override
    public void updateAgreement(Agreement agreement) {
        agreementRepository.saveAndFlush(agreement);
    }
}

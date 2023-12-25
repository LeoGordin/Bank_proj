package BankProject.service.jpa;

import BankProject.domain.entity.jpa.JpaAccount;
import BankProject.domain.entity.jpa.JpaAgreement;
import BankProject.domain.entity.jpa.JpaClient;
import BankProject.repository.AgreementRepository;
import BankProject.repository.ClientRepository;
import BankProject.service.interfaces.AgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class JpaAgreementService implements AgreementService {

    @Autowired
    private AgreementRepository agreementRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<JpaAgreement> findAll() {
        return agreementRepository.findAll();
    }

    @Override
    public List<JpaAgreement> getByClientId(int clientId) {

        List <JpaAgreement> agreements = agreementRepository.findAll().stream()
                .filter(agreement -> agreement.getClientId() == clientId).collect(Collectors.toList());

        if (agreements.isEmpty()) {
            throw new NoSuchElementException();
        }

        return agreements;

    }
    @Override
    public JpaAgreement getById(UUID id) {
        return agreementRepository.findAll().stream()
                .filter(agreement -> agreement.getId().equals(id)).findFirst().get();
    }

    @Override
    public void removeById(UUID id) {
        agreementRepository.delete(findAll().stream()
                .filter(agreement -> agreement.getId().equals(id)).findFirst().get());
    }

    @Override
    public void createAgreement(JpaAgreement agreement) {
        agreementRepository.save(agreement);
    }

    @Override
    public void removeAgreement(JpaAgreement agreement) {
        agreementRepository.delete(agreement);
    }

    @Override
    public void updateAgreement(JpaAgreement agreement) {
        agreementRepository.saveAndFlush(agreement);
    }
}

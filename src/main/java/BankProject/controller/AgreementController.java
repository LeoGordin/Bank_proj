package BankProject.controller;

import BankProject.domain.entity.jpa.JpaAgreement;
import BankProject.service.jpa.JpaAgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController("/agreements")
public class AgreementController {

    @Autowired
    JpaAgreementService agreementService;


    @GetMapping
    public List<JpaAgreement> getAll() {
        return agreementService.getAll();
    }

    @GetMapping("/client/{clientId}")
    public List<JpaAgreement> getByClientId(@PathVariable int clientId) {
        return agreementService.getByClientId(clientId);
    }

    @GetMapping("/{id}")
    public JpaAgreement getById(@PathVariable UUID id) {
        return agreementService.getById(id);
    }


    @DeleteMapping("/{id}")
    public void removeById(@PathVariable UUID id) {
        agreementService.removeAgreement(agreementService.getById(id));
    }

    @PostMapping
    public void createAgreement(@RequestBody JpaAgreement agreement) {
        agreementService.createAgreement(agreement);
    }

    @DeleteMapping
    public void removeAgreement(@RequestBody JpaAgreement agreement) {
        agreementService.removeAgreement(agreement);
    }

    @PutMapping
    public void updateAgreement(@RequestBody JpaAgreement agreement) {
        agreementService.updateAgreement(agreement);
    }
}

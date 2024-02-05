package BankProject.controller;

import BankProject.domain.entity.Agreement;
import BankProject.domain.entity.dto.AgreementDTO;
import BankProject.service.AgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/agreement")
public class AgreementController {

    @Autowired
    AgreementService agreementService;


    @GetMapping("/all")
    public List<AgreementDTO> getAll() {
        return agreementService.findAll();
    }

    @GetMapping("/{clientId}")
    public List<AgreementDTO> getByClientId(@PathVariable int clientId) {
        return agreementService.getByClientId(clientId);
    }

    @GetMapping("/{id}")
    public AgreementDTO getById(@PathVariable UUID id) {
        return agreementService.getById(id);
    }


    @DeleteMapping("/{id}")
    public void removeById(@PathVariable UUID id) {
        agreementService.removeAgreement(agreementService.getById(id));
    }

    @PostMapping
    public void createAgreement(@RequestBody AgreementDTO agreement) {
        agreementService.createAgreement(agreement);
    }

    @DeleteMapping
    public void removeAgreement(@RequestBody AgreementDTO agreement) {
        agreementService.removeAgreement(agreement);
    }

}

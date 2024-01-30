package BankProject.controller;

import BankProject.domain.entity.Agreement;
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
    public List<Agreement> getAll() {
        return agreementService.findAll();
    }

    @GetMapping("/{clientId}")
    public List<Agreement> getByClientId(@PathVariable int clientId) {
        return agreementService.getByClientId(clientId);
    }

    @GetMapping("/{id}")
    public Agreement getById(@PathVariable UUID id) {
        return agreementService.getById(id);
    }


    @DeleteMapping("/{id}")
    public void removeById(@PathVariable UUID id) {
        agreementService.removeAgreement(agreementService.getById(id));
    }

    @PostMapping("/create")
    public void createAgreement(@RequestBody Agreement agreement) {
        agreementService.createAgreement(agreement);
    }

    @DeleteMapping("/delete")
    public void removeAgreement(@RequestBody Agreement agreement) {
        agreementService.removeAgreement(agreement);
    }

    @PutMapping("/update")
    public void updateAgreement(@RequestBody Agreement agreement) {
        agreementService.updateAgreement(agreement);
    }
}

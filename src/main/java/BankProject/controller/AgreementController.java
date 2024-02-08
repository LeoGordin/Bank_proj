package BankProject.controller;

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
    public AgreementDTO getById(@PathVariable int id) {
        return agreementService.getById(id);
    }


    @DeleteMapping("/delete/{id}")
    public void removeById(@PathVariable int id) {
        agreementService.removeAgreement(agreementService.getById(id));
    }

    @PostMapping("/save")
    public void saveAgreement(@RequestBody AgreementDTO agreement) {
        agreementService.saveAgreement(agreement);
    }

    @DeleteMapping("/delete")
    public void removeAgreement(@RequestBody AgreementDTO agreement) {
        agreementService.removeAgreement(agreement);
    }

}

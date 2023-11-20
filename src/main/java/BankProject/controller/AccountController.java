package BankProject.controller;

import BankProject.domain.entity.jpa.JpaAccount;
import BankProject.service.jpa.JpaAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    JpaAccountService accountService;

    @GetMapping
    List<JpaAccount> getAll() {
        return accountService.findAll();
    }

    @RequestMapping("/client/{clientId}")
    List<JpaAccount> findByClientId(@PathVariable int clientId) {
        return accountService.findByClientId(clientId);
    }

    @RequestMapping("/{id}")
    JpaAccount findById( @PathVariable UUID id) {
        return accountService.findById(id);
    }

    @PostMapping
    public JpaAccount createAccount(@RequestBody JpaAccount account) {
        accountService.createAccount(account);
        return account;
    }

    @DeleteMapping
    public void deleteAccount(@RequestBody JpaAccount account) {
        accountService.deleteAccount(account);
        System.out.println("Account deleted");
    }



}

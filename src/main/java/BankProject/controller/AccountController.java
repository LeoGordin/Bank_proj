package BankProject.controller;

import BankProject.domain.entity.Account;
import BankProject.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/all")
    List<Account> getAll() {
        return accountService.findAll();
    }

    @RequestMapping("/{id}")
    Account findById(@PathVariable UUID id) {
        return accountService.findById(id);
    }

    @PostMapping("/create")
    public Account createAccount(@RequestBody Account account) {
        accountService.createAccount(account);
        return account;
    }

    @DeleteMapping
    public void deleteAccount(@RequestBody Account account) {
        accountService.deleteAccount(account);
        System.out.println("Account deleted");
    }

    @DeleteMapping("/{id}")
    public void deleteAccountById(@PathVariable UUID id) {
        accountService.deleteAccountById(id);
        System.out.printf("Account with id %s deleted", id);
    }



}

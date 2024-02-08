package BankProject.controller;

import BankProject.domain.entity.dto.AccountDTO;
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
    List<AccountDTO> getAll() {
        return accountService.findAll();
    }

    @RequestMapping("/{id}")
    AccountDTO findById(@PathVariable int id) {
        return accountService.findById(id);
    }

    @PostMapping("/add")
    public AccountDTO saveAccount(@RequestBody AccountDTO account) {
        accountService.saveAccount(account);
        return account;
    }

    @DeleteMapping("/delete")
    public void deleteAccount(@RequestBody AccountDTO account) {
        accountService.deleteAccount(account);
        System.out.println("Account deleted");
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAccountById(@PathVariable int id) {
        accountService.deleteAccountById(id);
        System.out.printf("Account with id %s deleted", id);
    }

}

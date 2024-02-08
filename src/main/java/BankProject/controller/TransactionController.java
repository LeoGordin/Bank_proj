package BankProject.controller;


import BankProject.domain.entity.Account;
import BankProject.domain.entity.Client;
import BankProject.domain.entity.Transaction;
import BankProject.domain.entity.dto.AccountDTO;
import BankProject.domain.entity.dto.TransactionDTO;
import BankProject.service.AccountService;
import BankProject.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @Autowired
    AccountService accountService;

    @GetMapping("/all")
    public List<TransactionDTO> getAll() {
        return transactionService.findAll();
    }

    @GetMapping("/{id}")
    public TransactionDTO getById(@PathVariable int id) {
        return transactionService.getById(id);
    }

    @GetMapping("/account/{accountId}")
    public List<TransactionDTO> getTransactionsByAccountId(@PathVariable int accountId, @PathVariable Timestamp from, @PathVariable Timestamp to) {
        return transactionService.getTransactionsByAccountID(accountId, from, to);
    }

    @GetMapping("/client/{clientId}")
    public List<TransactionDTO> getTransactions(@PathVariable int clientId, @PathVariable Timestamp from, @PathVariable Timestamp to) {
        return transactionService.getTransactionsByClientId(clientId, from, to);
    }

    @PostMapping("/transfer/{from}/{to}/{amount}")
    public void transferMoney(@PathVariable int from, @PathVariable int to, @PathVariable BigDecimal amount) {
        AccountDTO accountFrom = accountService.getAccountById(from);
        AccountDTO accountTo = accountService.getAccountById(to);

        accountService.transfer(accountFrom, accountTo, amount);

        System.out.println("Transaction successful");
    }

    @PostMapping("/deposit/{accountId}/{amount}")
    public void deposit(@PathVariable int accountId, @PathVariable BigDecimal amount) {
        AccountDTO account = accountService.getAccountById(accountId);

        accountService.deposit(account, amount);

        System.out.println("Deposit successful");
    }

    @PostMapping("/withdraw/{accountId}/{amount}")
    public void withdraw(@PathVariable int accountId, @PathVariable BigDecimal amount) {
        AccountDTO account = accountService.getAccountById(accountId);

        accountService.withdraw(account, amount);

        System.out.println("Withdraw successful");
    }
}

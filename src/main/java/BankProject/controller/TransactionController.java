package BankProject.controller;


import BankProject.domain.entity.Client;
import BankProject.domain.entity.Transaction;
import BankProject.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping("/all")
    public List<Transaction> getAll() {
        return transactionService.findAll();
    }

    @GetMapping("/{id}")
    public Transaction getById(@PathVariable UUID id) {
        return transactionService.getById(id);
    }

    @GetMapping("/account/{accountId}")
    public List<Transaction> getTransactions(@PathVariable UUID accountId, Timestamp from, Timestamp to) {
        return transactionService.getTransactionsByAccount(accountId, from, to);
    }

    @GetMapping("/client/{clientId}")
    public List<Transaction> getTransactions(@PathVariable Client client, Timestamp from, Timestamp to) {
        return transactionService.getTransactionsByClient(client, from, to);
    }

}

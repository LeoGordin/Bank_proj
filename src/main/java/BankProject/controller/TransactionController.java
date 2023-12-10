package BankProject.controller;


import BankProject.domain.entity.jpa.JpaTransaction;
import BankProject.service.jpa.JpaTransactionService;
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
    JpaTransactionService transactionService;

    @GetMapping
    public List<JpaTransaction> getAll() {
        return transactionService.findAll();
    }

    @GetMapping("/{id}")
    public JpaTransaction getById(@PathVariable UUID id) {
        return transactionService.getById(id);
    }

    @GetMapping("/account/{accountId}")
    public List<JpaTransaction> getTransactions(@PathVariable UUID accountId, Timestamp from, Timestamp to) {
        return transactionService.getTransactionsByAccount(accountId, from, to);
    }

    @GetMapping("/client/{clientId}")
    public List<JpaTransaction> getTransactions(@PathVariable int clientId, Timestamp from, Timestamp to) {
        return transactionService.getTransactionsByClient(clientId, from, to);
    }

}

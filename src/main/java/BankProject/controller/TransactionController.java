package BankProject.controller;


import BankProject.domain.entity.Client;
import BankProject.domain.entity.Transaction;
import BankProject.domain.entity.dto.TransactionDTO;
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
}

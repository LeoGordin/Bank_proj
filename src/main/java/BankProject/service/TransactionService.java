package BankProject.service;


import BankProject.domain.entity.Client;
import BankProject.domain.entity.Transaction;
import BankProject.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Service
public class TransactionService implements BankProject.service.interfaces.TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction getById(UUID id) {
        return transactionRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void createTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    @Override
    @Transactional
    public void deleteTransactionbyId(UUID id) {
        transactionRepository.deleteById(id);
    }

    @Override
    public List<Transaction> getTransactionsByAccount(UUID CreditAccountId, java.sql.Timestamp from, java.sql.Timestamp to) {

        return transactionRepository.findByCreditAccountIdAndCreatedAtAndCreatedAt(CreditAccountId, from, to);
    }

    @Override
    public List<Transaction> getTransactionsByClient(Client client, Timestamp from, Timestamp to) {

        return transactionRepository.findByClientAndCreatedAtAndCreatedAt(client, from, to);
    }
    @Override
    public List<Transaction> getTransactionsByTime(Timestamp from, Timestamp to) {

        return transactionRepository.findByCreatedAtAndCreatedAt(from, to);
    }
}

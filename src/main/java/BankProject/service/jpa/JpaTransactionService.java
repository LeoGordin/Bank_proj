package BankProject.service.jpa;

import BankProject.domain.entity.jpa.JpaAccount;
import BankProject.domain.entity.jpa.JpaTransaction;
import BankProject.repository.AccountRepository;
import BankProject.repository.TransactionRepository;
import BankProject.service.interfaces.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class JpaTransactionService implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    AccountRepository accountRepository;

    @Override
    public List<JpaTransaction> findAll() {
        return transactionRepository.findAll();
    }

    @Override
    public JpaTransaction getById(UUID id) {
        return transactionRepository.findById(id).orElse(null);
    }

    @Override
    public void createTransaction(JpaTransaction transaction) {
        transactionRepository.save(transaction);
    }

    @Override
    public void deleteTransaction(JpaTransaction transaction) {
        transactionRepository.delete(transaction);
    }

    @Override
    public void updateTransaction(JpaTransaction transaction) {
        transactionRepository.saveAndFlush(transaction);
    }

    @Override
    public List<JpaTransaction> getTransactionsByAccount(UUID CreditAccountId, java.sql.Timestamp from, java.sql.Timestamp to) {

        return transactionRepository.findByCreditAccountIdAndCreatedAt(CreditAccountId, from, to);
    }

    @Override
    public List<JpaTransaction> getTransactionsByClient(int clientId, Timestamp from, Timestamp to) {

        return transactionRepository.findByClientIdAndCreatedAt(clientId, from, to);
    }
}

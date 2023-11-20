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

    @Autowired
    JpaAccountService accountService;

    @Override
    public List<JpaTransaction> getAll() {
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

        List<JpaTransaction> transactions = new ArrayList<>();
        transactionRepository.findAll().stream().filter(
                transaction -> transaction.getCreditAccountId().equals(CreditAccountId)
                        && transaction.getCreationDate().after(from)
                        && transaction.getCreationDate().before(to)
        ).forEach(transactions::add);
        return transactions;
    }

    @Override
    public List<JpaTransaction> getTransactionsByClient(int clientId, Timestamp from, Timestamp to) {
        List<JpaAccount> accounts = accountService.findByClientId(clientId);

        List<JpaTransaction> transactions = new ArrayList<>();

        transactionRepository.findAll().stream().filter(
                transaction -> accounts.stream().anyMatch(account -> account.getId().equals(transaction.getCreditAccountId()))
                        && transaction.getCreationDate().after(from)
                        && transaction.getCreationDate().before(to)
        ).forEach(transactions::add);

        return transactions;
    }
}

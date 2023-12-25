package BankProject.serviceTest;

import BankProject.domain.entity.jpa.JpaClient;
import BankProject.service.jpa.JpaTransactionService;
import BankProject.domain.entity.jpa.JpaTransaction;
import BankProject.repository.TransactionRepository;
import BankProject.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class JpaTransactionServiceTest {

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private JpaTransactionService transactionService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAll() {
        // Arrange
        List<JpaTransaction> transactions = new ArrayList<>();
        when(transactionRepository.findAll()).thenReturn(transactions);

        // Act
        List<JpaTransaction> result = transactionService.findAll();

        // Assert
        verify(transactionRepository, times(1)).findAll();

    }

    @Test
    public void testGetById() {
        // Arrange
        UUID id = UUID.randomUUID();
        JpaTransaction transaction = new JpaTransaction();
        when(transactionRepository.findById(id)).thenReturn(java.util.Optional.of(transaction));

        // Act
        JpaTransaction result = transactionService.getById(id);

        // Assert
        verify(transactionRepository, times(1)).findById(id);
    }

    @Test
    public void testCreateTransaction() {
        // Arrange
        JpaTransaction transaction = new JpaTransaction();

        // Act
        transactionService.createTransaction(transaction);

        // Assert
        verify(transactionRepository, times(1)).save(transaction);

    }

    @Test
    public void testDeleteTransaction() {
        // Arrange
        JpaTransaction transaction = new JpaTransaction();

        // Act
        transactionService.deleteTransaction(transaction);

        // Assert
        verify(transactionRepository, times(1)).delete(transaction);
    }

    @Test
    public void testUpdateTransaction() {
        // Arrange
        JpaTransaction transaction = new JpaTransaction();

        // Act
        transactionService.updateTransaction(transaction);

        // Assert
        verify(transactionRepository, times(1)).saveAndFlush(transaction);
    }

    @Test
    public void testGetTransactionsByAccount() {
        // Arrange
        UUID creditAccountId = UUID.randomUUID();
        Timestamp from = Timestamp.valueOf("2022-01-01 00:00:00");
        Timestamp to = Timestamp.valueOf("2022-01-31 23:59:59");

        List<JpaTransaction> expectedTransactions = new ArrayList<>();

        JpaTransaction transaction1 = new JpaTransaction();
        transaction1.setCreditAccountId(creditAccountId);
        transaction1.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        expectedTransactions.add(transaction1);

        JpaTransaction transaction2 = new JpaTransaction();
        transaction2.setCreditAccountId(creditAccountId);
        transaction2.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        expectedTransactions.add(transaction2);

        when(transactionRepository.findByCreditAccountIdAndTimestampBetween(creditAccountId, from, to)).thenReturn(expectedTransactions);

        // Act
        List<JpaTransaction> actualTransactions = transactionService.getTransactionsByAccount(creditAccountId, from, to);

        // Assert
        assertEquals(expectedTransactions, actualTransactions);
        verify(transactionRepository, times(1)).findByCreditAccountIdAndTimestampBetween(creditAccountId, from, to);
    }

    @Test
    public void testGetTransactionsByClient() {
        // Arrange
        int clientId = 123;
        Timestamp from = Timestamp.valueOf("2022-01-01 00:00:00");
        Timestamp to = Timestamp.valueOf("2022-01-31 23:59:59");

        List<JpaTransaction> expectedTransactions = new ArrayList<>();
        when(transactionRepository.findByClientIdAndCreatedAt(clientId, from, to)).thenReturn(expectedTransactions);

        // Act
        List<JpaTransaction> result = transactionService.getTransactionsByClient(clientId, from, to);

        // Assert
        verify(transactionRepository, times(1)).findByClientIdAndCreatedAt(clientId, from, to);
        assertEquals(expectedTransactions, result);
    }

    }

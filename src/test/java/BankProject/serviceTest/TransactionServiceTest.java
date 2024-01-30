package BankProject.serviceTest;

import BankProject.domain.entity.Client;
import BankProject.domain.entity.Transaction;
import BankProject.repository.TransactionRepository;
import BankProject.service.TransactionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.*;

public class TransactionServiceTest {

    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private TransactionService transactionService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAll() {
        // Arrange
        List<Transaction> transactions = new ArrayList<>();
        when(transactionRepository.findAll()).thenReturn(transactions);

        // Act
        List<Transaction> result = transactionService.findAll();

        // Assert
        verify(transactionRepository, times(1)).findAll();
        Assertions.assertEquals(transactions, result);

    }

    @Test
    public void testGetById() {
        // Arrange
        UUID id = UUID.randomUUID();
        Transaction transaction = new Transaction();
        when(transactionRepository.findById(id)).thenReturn(java.util.Optional.of(transaction));

        // Act
        Transaction result = transactionService.getById(id);

        // Assert
        verify(transactionRepository, times(1)).findById(id);
        Assertions.assertEquals(transaction, result);
    }

    @Test
    public void testCreateTransaction() {

        // Arrange
        Transaction transaction = new Transaction();

        // Act
        transactionService.createTransaction(transaction);

        // Assert
        verify(transactionRepository, times(1)).save(transaction);
        Assertions.assertEquals(transaction, transactionService.getById(transaction.getId()));
    }

    @Test
    public void testDeleteTransaction() {
        // Arrange
        Transaction transaction = new Transaction();

        // Act
        transactionService.deleteTransactionbyId(transaction.getId());

        // Assert
        verify(transactionRepository, times(1)).deleteById(transaction.getId());
        Assertions.assertNull(transactionService.getById(transaction.getId()));
    }

    @Test
    public void testGetTransactionsByAccount() {
        // Arrange
        UUID creditAccountId = UUID.randomUUID();
        Timestamp from = Timestamp.valueOf("2022-01-01 00:00:00");
        Timestamp to = Timestamp.valueOf("2022-01-31 23:59:59");

        List<Transaction> expectedTransactions = new ArrayList<>();

        Transaction transaction1 = new Transaction();
        transaction1.setCreditAccountId(creditAccountId);
        transaction1.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        expectedTransactions.add(transaction1);

        Transaction transaction2 = new Transaction();
        transaction2.setCreditAccountId(creditAccountId);
        transaction2.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        expectedTransactions.add(transaction2);

        when(transactionRepository.findByCreditAccountIdAndCreatedAtAndCreatedAt(creditAccountId, from, to)).thenReturn(expectedTransactions);

        // Act
        List<Transaction> actualTransactions = transactionService.getTransactionsByAccount(creditAccountId, from, to);

        // Assert
        Assertions.assertEquals(expectedTransactions, actualTransactions);
        verify(transactionRepository, times(1)).findByCreditAccountIdAndCreatedAtAndCreatedAt(creditAccountId, from, to);
    }

    @Test
    public void testGetTransactionsByClient() {
        // Arrange
        Client client = new Client();
        Timestamp from = Timestamp.valueOf("2022-01-01 00:00:00");
        Timestamp to = Timestamp.valueOf("2022-01-31 23:59:59");

        List<Transaction> expectedTransactions = new ArrayList<>();
        when(transactionRepository.findByClientAndCreatedAtAndCreatedAt(client, from, to)).thenReturn(expectedTransactions);

        // Act
        List<Transaction> result = transactionService.getTransactionsByClient(client, from, to);

        // Assert
        verify(transactionRepository, times(1)).findByClientAndCreatedAtAndCreatedAt(client, from, to);
        Assertions.assertEquals(expectedTransactions, result);
    }

    @Test
    public void testGetTransactionsByTime() {
        // Arrange
        Timestamp from = Timestamp.valueOf("2022-01-01 00:00:00");
        Timestamp to = Timestamp.valueOf("2022-01-31 23:59:59");

        List<Transaction> expectedTransactions = new ArrayList<>();

        Transaction transaction = new Transaction();

        when(transactionRepository.findByCreatedAtAndCreatedAt(from, to)).thenReturn(expectedTransactions);

        // Act
        List<Transaction> result = transactionService.getTransactionsByTime(from, to);

        // Assert
        verify(transactionRepository, times(1)).findByCreatedAtAndCreatedAt(from, to);
        Assertions.assertEquals(expectedTransactions, result);
    }

    }

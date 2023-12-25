package BankProject.serviceTest;

import BankProject.domain.entity.jpa.JpaAccount;
import BankProject.domain.entity.jpa.JpaTransaction;
import BankProject.repository.AccountRepository;
import BankProject.repository.ClientRepository;
import BankProject.repository.TransactionRepository;
import BankProject.service.jpa.JpaAccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class JpaAccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private JpaAccountService accountService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAll() {
        // Arrange
        List<JpaAccount> expectedAccounts = Arrays.asList(new JpaAccount(), new JpaAccount());
        when(accountRepository.findAll()).thenReturn(expectedAccounts);

        // Act
        List<JpaAccount> actualAccounts = accountService.findAll();

        // Assert
        assertEquals(expectedAccounts, actualAccounts);
        verify(accountRepository, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        // Arrange
        UUID accountId = UUID.randomUUID();
        JpaAccount expectedAccount = new JpaAccount();
        when(accountRepository.findById(accountId)).thenReturn(Optional.of(expectedAccount));

        // Act
        JpaAccount actualAccount = accountService.findById(accountId);

        // Assert
        assertEquals(expectedAccount, actualAccount);
        verify(accountRepository, times(1)).findById(accountId);
    }

    @Test
    public void testCreateAccount() {
        // Arrange
        JpaAccount account = new JpaAccount();

        // Act
        accountService.createAccount(account);

        // Assert
        verify(accountRepository, times(1)).save(account);
    }

    @Test
    public void testDeleteAccount() {
        // Arrange
        JpaAccount account = new JpaAccount();

        // Act
        accountService.deleteAccount(account);

        // Assert
        verify(accountRepository, times(1)).delete(account);
    }

    @Test
    public void testUpdateAccount() {
        // Arrange
        JpaAccount account = new JpaAccount();

        // Act
        accountService.updateAccount(account);

        // Assert
        verify(accountRepository, times(1)).saveAndFlush(account);
    }

    @Test
    public void testGetBalance() {
        // Arrange
        JpaAccount account = new JpaAccount();
        account.setBalance(BigDecimal.valueOf(100.0));

        // Act
        BigDecimal actualBalance = accountService.getBalance(account);

        // Assert
        assertEquals(BigDecimal.valueOf(100.0), actualBalance);
    }

    @Test
    public void testDeposit() {
        // Arrange
        JpaAccount account = new JpaAccount();
        account.setBalance(BigDecimal.valueOf(0.0));
        BigDecimal amount = BigDecimal.valueOf(100.0);

        // Act
        accountService.deposit(account, amount);

        // Assert
        assertEquals(BigDecimal.valueOf(100.0), account.getBalance());
        verify(accountRepository, times(1)).save(account);
        verify(transactionRepository, times(1)).save(any(JpaTransaction.class));
    }

    @Test
    public void testWithdraw() {
        // Arrange
        JpaAccount account = new JpaAccount();
        account.setBalance(BigDecimal.valueOf(100.0));
        BigDecimal amount = BigDecimal.valueOf(50.0);

        // Act
        accountService.withdraw(account, amount);

        // Assert
        assertEquals(BigDecimal.valueOf(50.0), account.getBalance());
        verify(accountRepository, times(1)).save(account);
        verify(transactionRepository, times(1)).save(any(JpaTransaction.class));
    }

    @Test
    public void testTransfer() {
        // Arrange
        JpaAccount from = new JpaAccount();
        JpaAccount to = new JpaAccount();
        from.setBalance(BigDecimal.valueOf(100.0));
        to.setBalance(BigDecimal.valueOf(0.0));
        BigDecimal amount = BigDecimal.valueOf(50.0);

        // Act
        accountService.transfer(from, to, amount);

        // Assert
        assertEquals(BigDecimal.valueOf(50.0), from.getBalance());
        assertEquals(BigDecimal.valueOf(50.0), to.getBalance());
        verify(accountRepository, times(2)).save(any(JpaAccount.class));
        verify(transactionRepository, times(1)).save(any(JpaTransaction.class));
    }

}
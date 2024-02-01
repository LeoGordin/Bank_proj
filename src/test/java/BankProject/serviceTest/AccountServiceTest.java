package BankProject.serviceTest;

import BankProject.domain.entity.Account;
import BankProject.domain.entity.Transaction;
import BankProject.repository.AccountRepository;
import BankProject.repository.TransactionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private BankProject.service.AccountService accountService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAll() {
        // Arrange
        List<Account> expectedAccounts = Arrays.asList(new Account(), new Account());
        when(accountRepository.findAll()).thenReturn(expectedAccounts);

        // Act
        List<Account> actualAccounts = accountService.findAll();

        // Assert
        assertEquals(expectedAccounts, actualAccounts);
        verify(accountRepository, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        // Arrange
        UUID accountId = UUID.randomUUID();
        Account expectedAccount = new Account();
        when(accountRepository.findById(accountId)).thenReturn(Optional.of(expectedAccount));

        // Act
        Account actualAccount = accountService.findById(accountId);

        // Assert
        assertEquals(expectedAccount, actualAccount);
        verify(accountRepository, times(1)).findById(accountId);
    }

    @Test
    public void testCreateAccount() {
        // Arrange
        Account account = new Account();
        UUID id = account.getId();

        // Act
        accountService.createAccount(account);

        // Assert
        verify(accountRepository, times(1)).save(account);
        Assertions.assertEquals(id, account.getId());
    }

    @Test
    public void testDeleteAccount() {
        // Arrange
        Account account = new Account();

        // Act
        accountService.deleteAccount(account);

        // Assert
        verify(accountRepository, times(1)).delete(account);
    }

    @Test
    public void testDeleteAccountById() {
        // Arrange
        Account accountOne = new Account();
        Account accountTwo = new Account();

        UUID idOne = accountOne.getId();
        UUID idTwo = accountTwo.getId();

        List<Account> accounts = Arrays.asList(accountOne, accountTwo);
        when(accountRepository.findAll()).thenReturn(accounts);

        // Act
        accountService.deleteAccountById(idOne);

        // Assert

        verify(accountRepository, times(1)).deleteById(idOne);
        Assertions.assertTrue(accounts.contains(accountTwo));
        Assertions.assertFalse(accounts.contains(accountOne));

    }

    @Test
    public void testUpdateAccount() {
        // Arrange
        Account account = new Account();

        // Act
        accountService.updateAccount(account);

        // Assert
        verify(accountRepository, times(1)).saveAndFlush(account);
    }

    @Test
    public void testGetBalance() {
        // Arrange
        Account account = new Account();
        account.setBalance(BigDecimal.valueOf(100.0));

        // Act
        BigDecimal actualBalance = accountService.getBalance(account);

        // Assert
        assertEquals(BigDecimal.valueOf(100.0), actualBalance);
    }

    @Test
    public void testDeposit() {
        // Arrange
        Account account = new Account();
        account.setBalance(BigDecimal.valueOf(0.0));
        BigDecimal amount = BigDecimal.valueOf(100.0);

        // Act
        accountService.deposit(account, amount);

        // Assert
        assertEquals(BigDecimal.valueOf(100.0), account.getBalance());
        verify(accountRepository, times(1)).save(account);
        verify(transactionRepository, times(1)).save(any(Transaction.class));
    }

    @Test
    public void testWithdraw() {
        // Arrange
        Account account = new Account();
        account.setBalance(BigDecimal.valueOf(100.0));
        BigDecimal amount = BigDecimal.valueOf(50.0);

        // Act
        accountService.withdraw(account, amount);

        // Assert
        assertEquals(BigDecimal.valueOf(50.0), account.getBalance());
        verify(accountRepository, times(1)).save(account);
        verify(transactionRepository, times(1)).save(any(Transaction.class));
    }

    @Test
    public void testTransfer() {
        // Arrange
        Account from = new Account();
        Account to = new Account();
        from.setBalance(BigDecimal.valueOf(100.0));
        to.setBalance(BigDecimal.valueOf(0.0));
        BigDecimal amount = BigDecimal.valueOf(50.0);

        // Act
        accountService.transfer(from, to, amount);

        // Assert
        assertEquals(BigDecimal.valueOf(50.0), from.getBalance());
        assertEquals(BigDecimal.valueOf(50.0), to.getBalance());
        verify(accountRepository, times(2)).save(any(Account.class));
        verify(transactionRepository, times(1)).save(any(Transaction.class));
    }

}
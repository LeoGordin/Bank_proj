package BankProject.service;

import BankProject.domain.entity.Account;
import BankProject.domain.entity.Transaction;
import BankProject.domain.entity.User;
import BankProject.domain.entity.dto.AccountDTO;
import BankProject.domain.entity.enums.TransactionType;
import BankProject.repository.AccountRepository;
import BankProject.repository.TransactionRepository;
import BankProject.service.mapping.AccountMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AccountService implements BankProject.service.interfaces.AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    AccountMappingService accountMappingService;

    @Override
    public List<AccountDTO> findAll() {
        return accountRepository.findAll().stream().map(accountMappingService::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public AccountDTO findById(UUID id) {
        Account account = accountRepository.findById(id).isPresent() ? accountRepository.findById(id).get() : null;
        if (account == null) {
            throw new NoSuchElementException();
        }
        return accountMappingService.mapToDTO(account);
    }

    @Override
    public AccountDTO createAccount(AccountDTO account) {
        Account savedAccount = accountRepository.save(accountMappingService.mapToEntity(account));
        return accountMappingService.mapToDTO(savedAccount);
    }

    @Override
    public void deleteAccount(AccountDTO account) {

        accountRepository.delete(accountMappingService.mapToEntity(account));
    }

    @Override
    public void deleteAccountById(UUID id) {
        accountRepository.deleteById(id);
    }

    @Override
    public BigDecimal getBalance(AccountDTO accountDTO) {

        Account account = accountMappingService.mapToEntity(accountDTO);

        return account.getBalance();
    }

    @Override
    public void deposit(AccountDTO accountDTO, BigDecimal amount) {

        Account account = accountMappingService.mapToEntity(accountDTO);

        TransactionType type = TransactionType.DEPOSIT;

        BigDecimal balance = account.getBalance();
        balance = balance.add(amount);
        account.setBalance(balance);

        accountRepository.save(account);
        transactionRepository.save(
                new Transaction(
                        null,
                        account.getId(),
                        account.getId(),
                        type,
                        amount,
                        String.format("Deposit to %s", account.getId()),
                        null,
                        account.getClient()
                )
        );
    }

    @Override
    public void withdraw(AccountDTO accountDTO, BigDecimal amount) {

        TransactionType type = TransactionType.WITHDRAW;

        Account account = accountMappingService.mapToEntity(accountDTO);

        BigDecimal balance = account.getBalance();
        if (balance.compareTo(amount) < 0) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        balance = balance.subtract(amount);
        account.setBalance(balance);

        accountRepository.save(account);
        transactionRepository.save(
                new Transaction(
                        null,
                        account.getId(),
                        account.getId(),
                        type,
                        amount,
                        String.format("Withdrawal from %s", account.getId()),
                        null,
                        account.getClient()
                )
        );
    }

    @Override
    public void transfer(AccountDTO fromDTO, AccountDTO toDTO, BigDecimal amount) {

        TransactionType type = TransactionType.TRANSFER;

        Account from = accountMappingService.mapToEntity(fromDTO);
        Account to = accountMappingService.mapToEntity(toDTO);

        BigDecimal fromBalance = from.getBalance();
        BigDecimal toBalance = to.getBalance();

        if (fromBalance.compareTo(amount) < 0) {
            throw new IllegalArgumentException("Insufficient funds");
        }

        from.setBalance(fromBalance.subtract(amount));
        to.setBalance(toBalance.add(amount));

        accountRepository.save(from);

        accountRepository.save(to);

        transactionRepository.save(
                new Transaction(
                        null,
                        from.getId(),
                        to.getId(),
                        type,
                        amount,
                        String.format("Transfer from %s to %s", from.getId(), to.getId()),
                        null,
                        from.getClient()
                )
        );
    }

}

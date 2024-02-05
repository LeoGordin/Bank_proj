package BankProject.domain.entity.dto;

import BankProject.domain.entity.Client;
import BankProject.domain.entity.Product;
import BankProject.domain.entity.enums.AccountStatus;
import BankProject.domain.entity.enums.AccountType;
import java.math.BigDecimal;
import java.sql.Timestamp;
import BankProject.domain.entity.enums.Currency;
import lombok.Data;

import java.util.UUID;

@Data
public class AccountDTO {

    private UUID id;
    private Client client;
    private Product product;
    private String name;
    private AccountStatus status;
    private AccountType type;
    private BigDecimal balance;
    private Currency currency;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}

package BankProject.domain.entity.dto;

import BankProject.domain.entity.Client;
import BankProject.domain.entity.enums.TransactionType;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

@Data
public class TransactionDTO {

    private UUID id;
    private UUID creditAccountId;
    private UUID debitAccountId;
    private TransactionType type;
    private BigDecimal amount;
    private String description;
    private Timestamp createdAt;
    private Client client;
}

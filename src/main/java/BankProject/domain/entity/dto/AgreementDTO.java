package BankProject.domain.entity.dto;

import BankProject.domain.entity.Account;
import BankProject.domain.entity.Client;
import BankProject.domain.entity.Product;
import BankProject.domain.entity.enums.AgreementStatus;
import BankProject.domain.entity.enums.Currency;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

@Data
public class AgreementDTO {

    private UUID id;
    private Account account;
    private Product product;
    private Client client;
    private float interestRate;
    private AgreementStatus status;
    private BigDecimal sum;
    private Currency currency;
    private Timestamp createdAt;
    private Timestamp updatedAt;

}

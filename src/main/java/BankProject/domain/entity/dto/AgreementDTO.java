package BankProject.domain.entity.dto;

import BankProject.domain.entity.Account;
import BankProject.domain.entity.Client;
import BankProject.domain.entity.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class AgreementDTO {

    private int id;
    private Account account;
    private Product product;
    private Client client;
    private float interestRate;
    private String status;
    private BigDecimal sum;
    private String currency;
    private Timestamp createdAt;
    private Timestamp updatedAt;

}

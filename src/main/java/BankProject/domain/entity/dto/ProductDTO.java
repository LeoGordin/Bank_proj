package BankProject.domain.entity.dto;

import BankProject.domain.entity.Manager;
import BankProject.domain.entity.enums.Currency;
import BankProject.domain.entity.enums.ProductStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
public class ProductDTO {

    private int id;
    private Manager manager;
    private String name;
    private ProductStatus status;
    private Currency currency;
    private BigDecimal interestRate;
    private BigDecimal limit;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}

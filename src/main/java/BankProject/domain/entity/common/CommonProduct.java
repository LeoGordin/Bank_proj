package BankProject.domain.entity.common;

import BankProject.domain.entity.interfaces.Product;


import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;


public class CommonProduct implements Product {

    private int id;

    private int managerId;

    private String name;

    private int status;

    private int currencyCode;

    private BigDecimal interestRate;

    private BigDecimal limit;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    public CommonProduct() {

    }

    public CommonProduct(
            int id,
            int managerId,
            String name,
            int status,
            int currencyCode,
            BigDecimal interestRate,
            BigDecimal limit,
            Timestamp createdAt,
            Timestamp updatedAt)
    {
        this.id = id;
        this.managerId = managerId;
        this.name = name;
        this.status = status;
        this.currencyCode = currencyCode;
        this.interestRate = interestRate;
        this.limit = limit;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }





    @Override
    public int hashCode() {
        return Objects.hash(getId(),
                getManagerId(),
                getName(),
                getStatus(),
                getCurrencyCode(),
                getInterestRate(),
                getLimit(),
                getCreatedAt(),
                getUpdatedAt());
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public int getManagerId() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getStatus() {
        return 0;
    }

    @Override
    public int getCurrencyCode() {
        return 0;
    }

    @Override
    public BigDecimal getInterestRate() {
        return null;
    }

    @Override
    public BigDecimal getLimit() {
        return null;
    }

    @Override
    public Timestamp getCreatedAt() {
        return null;
    }

    @Override
    public Timestamp getUpdatedAt() {
        return null;
    }
}

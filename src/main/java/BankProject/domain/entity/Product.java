package BankProject.domain.entity;

import BankProject.domain.entity.interfaces.ProductInterface;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Product implements ProductInterface {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manager_id")
    private Manager manager;

    @OneToOne(mappedBy = "product")
    private Account account;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private int status; // TODO enum status (1 = active, 0 = redundant)

    @Column(name = "currency_code")
    private int currencyCode; //TODO enum (1 = USD, 2 = EUR, 3 = CHF, 4 = CNY, 0 = ALL)

    @Column(name = "interest_rate")
    private BigDecimal interestRate;

    @Column(name = "limit")
    private BigDecimal limit;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getManagerId() {
        return manager.getId();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getStatus() {
        return status;
    }

    @Override
    public int getCurrencyCode() {
        return currencyCode;
    }

    @Override
    public BigDecimal getInterestRate() {
        return interestRate;
    }

    @Override
    public BigDecimal getLimit() {
        return limit;
    }

    @Override
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    @Override
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }
}

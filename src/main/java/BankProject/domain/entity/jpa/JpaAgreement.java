package BankProject.domain.entity.jpa;

import BankProject.domain.entity.interfaces.Agreement;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "agreement")
@NoArgsConstructor
@AllArgsConstructor
public class JpaAgreement implements Agreement {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private JpaAccount account;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private JpaProduct product;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private JpaClient client;

    @Column(name = "interest_rate")
    private float interestRate;

    @Column(name = "status")
    private int status;

    @Column(name = "sum")
    private BigDecimal sum;

    @Column(name = "currency_code")
    private String currencyCode;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public UUID getAccountId() {
        return account.getId();
    }

    @Override
    public int getProductId() {
        return product.getId();
    }

    @Override
    public float getInterestRate() {
        return interestRate;
    }

    @Override
    public int getStatus() {
        return status;
    }

    @Override
    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public BigDecimal getSum() {
        return sum;
    }

    @Override
    public String getCurrencyCode() {
        return currencyCode;
    }

    @Override
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    @Override
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public int getClientId() {
        return client.getId();
    }

    public void setClient(JpaClient client) {
        this.client = client;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}

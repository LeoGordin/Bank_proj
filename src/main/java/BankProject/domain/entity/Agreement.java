package BankProject.domain.entity;

import BankProject.domain.entity.enums.AgreementStatus;
import BankProject.domain.entity.enums.Currency;
import BankProject.domain.entity.interfaces.AgreementInterface;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "agreement")
@NoArgsConstructor
@AllArgsConstructor
public class Agreement implements AgreementInterface {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(name = "interest_rate")
    private float interestRate;

    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private AgreementStatus status;

    @Column(name = "sum")
    private BigDecimal sum;

    @Column(name = "currency_code")
    @Enumerated(EnumType.ORDINAL)
    private Currency currency;

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
    public AgreementStatus getStatus() {
        return status;
    }

    @Override
    public void setStatus(AgreementStatus status) {
        this.status = status;
    }

    @Override
    public BigDecimal getSum() {
        return sum;
    }

    @Override
    public Currency getCurrency() {
        return currency;
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

    @Override
    public void setClient(Client client) {
        this.client = client;
    }

}

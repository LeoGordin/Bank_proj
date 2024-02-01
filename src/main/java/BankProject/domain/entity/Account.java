package BankProject.domain.entity;

import BankProject.domain.entity.enums.AccountStatus;
import BankProject.domain.entity.enums.AccountType;
import BankProject.domain.entity.enums.Currency;
import BankProject.domain.entity.interfaces.AccountInterface;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "account")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Account implements AccountInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private AccountStatus status;

    @Column(name = "type")
    @Enumerated(EnumType.ORDINAL)
    private AccountType type;

    @Column(name = "balance")
    private BigDecimal balance;

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
    public int getClientId() {
        return client.getId();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public AccountType getType() {
        return type;
    }

    @Override
    public void setType(AccountType type) {
        this.type = type;
    }

    @Override
    public AccountStatus getStatus() {
        return status;
    }

    @Override
    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
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
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public Client getClient() {
        return client;
    }
}

package BankProject.domain.entity.jpa;

import BankProject.domain.entity.interfaces.Account;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.UUID;

@Entity
@Table(name = "account")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class JpaAccount implements Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private JpaClient client;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private JpaProduct product;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private int status;

    @Column(name = "balance")
    private BigDecimal balance;

    @Column(name = "currency_code")
    private int currencyCode;

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
    public int getStatus() {
        return status;
    }

    @Override
    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public int getCurrencyCode() {
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
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}

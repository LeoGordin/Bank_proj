package BankProject.domain.entity.jpa;

import BankProject.domain.entity.interfaces.Account;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "account")
public class JpaAccount implements Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @OneToOne
    @JoinColumn(name = "client_id")
    private String clientId;

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
    public String getId() {
        return id;
    }

    @Override
    public String getClientId() {
        return clientId;
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
}

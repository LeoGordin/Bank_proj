package BankProject.domain.entity;

import BankProject.domain.entity.interfaces.TransactionInterface;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "transaction")
@NoArgsConstructor
@AllArgsConstructor
public class Transaction implements TransactionInterface {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "credit_account_id")
    private UUID creditAccountId;

    @Column(name = "debit_account_id")
    private UUID debitAccountId;

    @Column(name = "type")
    private int type; // TODO enum type (1 = withdraw, 2 = deposit, 3 = transfer)

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "description")
    private String description;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;


    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public UUID getCreditAccountId() {
        return creditAccountId;
    }

    @Override
    public UUID getDebitAccountId() {
        return debitAccountId;
    }

    @Override
    public int getType() {
        return type;
    }

    @Override
    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setCreditAccountId(UUID creditAccountId) {
        this.creditAccountId = creditAccountId;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}

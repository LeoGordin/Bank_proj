package BankProject.domain.entity;

import BankProject.domain.entity.enums.TransactionType;
import BankProject.domain.entity.interfaces.TransactionInterface;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "transaction")
public class Transaction implements TransactionInterface {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Setter
    @Column(name = "credit_account_id")
    private UUID creditAccountId;

    @Column(name = "debit_account_id")
    private UUID debitAccountId;

    @Column(name = "type")
    @Enumerated(EnumType.ORDINAL)
    private TransactionType type;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "description")
    private String description;

    @Setter
    @Column(name = "created_at")
    private Timestamp createdAt;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @Getter
    @Setter
    private Client client;

    public Transaction() {
    }

    public Transaction(UUID id, UUID creditAccountId, UUID debitAccountId, TransactionType type, BigDecimal amount, String description, Timestamp createdAt, Client client) {
        this.id = id;
        this.creditAccountId = creditAccountId;
        this.debitAccountId = debitAccountId;
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.createdAt = createdAt;
        this.client = client;
    }

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
    public TransactionType getType() {
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

}

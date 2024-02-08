package BankProject.domain.entity;

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
    private int id;

    @Setter
    @Column(name = "credit_account_id")
    private int creditAccountId;

    @Column(name = "debit_account_id")
    private int debitAccountId;

    @Column(name = "type")
    private String type;

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

    public Transaction(int creditAccountId, int debitAccountId, String type, BigDecimal amount, String description, Client client) {
        this.creditAccountId = creditAccountId;
        this.debitAccountId = debitAccountId;
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.client = client;
    }



    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getCreditAccountId() {
        return creditAccountId;
    }

    @Override
    public int getDebitAccountId() {
        return debitAccountId;
    }

    @Override
    public String getType() {
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

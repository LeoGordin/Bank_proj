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
@NoArgsConstructor
@AllArgsConstructor
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

package BankProject.domain.entity.jpa;

import BankProject.domain.entity.interfaces.Transaction;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "transaction")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class JpaTransaction implements Transaction {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "credit_account_id")
    private UUID creditAccountId;

    @Column(name = "debit_account_id")
    private UUID debitAccountId;

    @Column(name = "type")
    private int type;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "description")
    private String description;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private JpaClient client;


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

    public void setCreditAccountId(UUID creditAccountId) {
        this.creditAccountId = creditAccountId;
    }

    public void setCreatedAt(Timestamp timestamp) {
        this.createdAt = timestamp;
    }

    public void setClient(JpaClient client) {
        this.client = client;
    }
}

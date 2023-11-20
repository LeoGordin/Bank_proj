package BankProject.domain.entity.jpa;

import BankProject.domain.entity.interfaces.Transaction;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "transaction")
@NoArgsConstructor
@AllArgsConstructor
public class JpaTransaction implements Transaction {

    @Column(name = "id")
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

    public JpaTransaction(UUID id, UUID creditAccountId, UUID debitAccountId, int type,
                          BigDecimal amount, Timestamp timestamp, String description) {

        this.id = id;
        this.creditAccountId = creditAccountId;
        this.debitAccountId = debitAccountId;
        this.type = type;
        this.amount = amount;
        this.description = description;
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
    public Timestamp getCreationDate() {
        return new Timestamp(new Date().getTime());
    }


}

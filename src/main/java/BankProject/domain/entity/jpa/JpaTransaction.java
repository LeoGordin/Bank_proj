package BankProject.domain.entity.jpa;

import BankProject.domain.entity.interfaces.Transaction;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Arrays;

@Entity
@Table(name = "transaction")
@NoArgsConstructor
@AllArgsConstructor
public class JpaTransaction implements Transaction {

    @Column(name = "id")
    private byte[] id;

    @Column(name = "credit_account_id")
    private byte[] creditAccountId;

    @Column(name = "debit_account_id")
    private byte[] debitAccountId;

    @Column(name = "type")
    private int type;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "description")
    private String description;


    @Override
    public String getId() {
        return Arrays.toString(id);
    }

    @Override
    public String getCreditAccountId() {
        return Arrays.toString(creditAccountId);
    }

    @Override
    public String getDebitAccountId() {
        return Arrays.toString(debitAccountId);
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
}

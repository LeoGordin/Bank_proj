package BankProject.domain.entity.dto;

import BankProject.domain.entity.Client;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;


public class TransactionDTO {

    private int id;
    private int creditAccountId;
    private int debitAccountId;
    private String type;
    private BigDecimal amount;
    private String description;
    private Timestamp createdAt;
    private Client client;

    public TransactionDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCreditAccountId() {
        return creditAccountId;
    }

    public void setCreditAccountId(int creditAccountId) {
        this.creditAccountId = creditAccountId;
    }

    public int getDebitAccountId() {
        return debitAccountId;
    }

    public void setDebitAccountId(int debitAccountId) {
        this.debitAccountId = debitAccountId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}

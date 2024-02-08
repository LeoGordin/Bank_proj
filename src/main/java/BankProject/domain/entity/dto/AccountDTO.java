package BankProject.domain.entity.dto;

import BankProject.domain.entity.Client;
import BankProject.domain.entity.Product;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

public class AccountDTO {

    private int id;
    private Client client;
    private Product product;
    private java.lang.String name;
    private java.lang.String status;
    private String type;
    private BigDecimal balance;
    private String currency;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public AccountDTO() {
    }

    public int getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public Product getProduct() {
        return product;
    }

    public java.lang.String getName() {
        return name;
    }

    public java.lang.String getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getCurrency() {
        return currency;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public void setStatus(java.lang.String status) {
        this.status = status;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}

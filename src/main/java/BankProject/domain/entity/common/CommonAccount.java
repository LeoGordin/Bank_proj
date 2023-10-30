package BankProject.domain.entity.common;

import BankProject.domain.entity.interfaces.Account;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Objects;


public class CommonAccount implements Account {

    private byte[] id;

    private byte[] clientId;

    private String name;

    private int status;

    private int currencyCode;

    private BigDecimal balance;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    public CommonAccount() {
    }

    public CommonAccount(
            byte[] id,
            byte[] clientId,
            String name,
            int status,
            int currencyCode,
            BigDecimal balance,
            Timestamp createdAt,
            Timestamp updatedAt)
    {
        this.id = id;
        this.clientId = clientId;
        this.name = name;
        this.status = status;
        this.currencyCode = currencyCode;
        this.balance = balance;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommonAccount)) return false;
        CommonAccount that = (CommonAccount) o;
        return
                getStatus() == that.getStatus() &&
                        getCurrencyCode() == that.getCurrencyCode() &&
                        Arrays.equals(getId().toCharArray(), that.getId().toCharArray()) &&
                        Arrays.equals(getClientId().toCharArray(), that.getClientId().toCharArray()) &&
                        Objects.equals(getName(), that.getName()) && Objects.equals(getBalance(),
                        that.getBalance()) && Objects.equals(getCreatedAt(), that.getCreatedAt()) &&
                        Objects.equals(getUpdatedAt(), that.getUpdatedAt());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getName(), getStatus(), getCurrencyCode(), getBalance(), getCreatedAt(), getUpdatedAt());
        result = 31 * result + Arrays.hashCode(getId().toCharArray());
        result = 31 * result + Arrays.hashCode(getClientId().toCharArray());
        return result;
    }

    @Override
    public String toString() {
        return "CommonAccount{" +
                "id=" + Arrays.toString(id) +
                ", clientId=" + Arrays.toString(clientId) +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", currencyCode=" + currencyCode +
                ", balance=" + balance +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    @Override
    public String getId() {
        return Arrays.toString(id);
    }

    @Override
    public String getClientId() {
        return Arrays.toString(clientId);
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

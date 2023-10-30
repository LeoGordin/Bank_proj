package BankProject.domain.entity.common;

import BankProject.domain.entity.interfaces.Transaction;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;

public class CommonTransaction implements Transaction {

    private byte[] id;

    private byte[] creditAccountId;

    private byte[] debitAccountId;

    private int type;

    private BigDecimal amount;

    private String description;

    public CommonTransaction(
            byte[] id,
            byte[] creditAccountId,
            byte[] debitAccountId,
            int type,
            BigDecimal amount,
            String description) {
        this.id = id;
        this.creditAccountId = creditAccountId;
        this.debitAccountId = debitAccountId;
        this.type = type;
        this.amount = amount;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommonTransaction)) return false;
        CommonTransaction that = (CommonTransaction) o;
        return getType() == that.getType() &&
                Arrays.equals(getId().toCharArray(), that.getId().toCharArray()) &&
                Arrays.equals(getCreditAccountId().toCharArray(), that.getCreditAccountId().toCharArray()) &&
                Arrays.equals(getDebitAccountId().toCharArray(), that.getDebitAccountId().toCharArray()) &&
                Objects.equals(getAmount(), that.getAmount()) &&
                Objects.equals(getDescription(), that.getDescription());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getType(), getAmount(), getDescription());
        result = 31 * result + Arrays.hashCode(getId().toCharArray());
        result = 31 * result + Arrays.hashCode(getCreditAccountId().toCharArray());
        result = 31 * result + Arrays.hashCode(getDebitAccountId().toCharArray());
        return result;
    }

    @Override
    public String toString() {
        return "CommonTransaction{" +
                "id=" + Arrays.toString(id) +
                ", creditAccountId=" + Arrays.toString(creditAccountId) +
                ", debitAccountId=" + Arrays.toString(debitAccountId) +
                ", type=" + type +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public String getId() {
        return id.toString();
    }

    @Override
    public String getCreditAccountId() {
        return creditAccountId.toString();
    }

    @Override
    public String getDebitAccountId() {
        return debitAccountId.toString();
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

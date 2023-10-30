package BankProject.domain.entity.common;

import BankProject.domain.entity.interfaces.Agreement;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Objects;

public class CommonAgreement implements Agreement {

    private int id;

    private String accountId;

    private String productId;

    private float interestRate;

    private int status;

    private BigDecimal sum;

    private String currencyCode;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    public CommonAgreement() {
    }

    public CommonAgreement
            (
                    int id,
                    String accountId,
                    String productId,
                    float interestRate,
                    int status,
                    BigDecimal sum,
                    String currencyCode,
                    Timestamp createdAt,
                    Timestamp updatedAt) {
        this.id = id;
        this.accountId = accountId;
        this.productId = productId;
        this.interestRate = interestRate;
        this.status = status;
        this.sum = sum;
        this.currencyCode = currencyCode;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommonAgreement)) return false;
        CommonAgreement that = (CommonAgreement) o;
        return getId() == that.getId() &&
                Float.compare(getInterestRate(), that.getInterestRate()) == 0 &&
                getStatus() == that.getStatus() &&
                Objects.equals(getAccountId(), that.getAccountId()) &&
                Objects.equals(getProductId(), that.getProductId()) &&
                Objects.equals(getSum(), that.getSum()) &&
                Objects.equals(getCurrencyCode(), that.getCurrencyCode()) &&
                Objects.equals(getCreatedAt(), that.getCreatedAt()) &&
                Objects.equals(getUpdatedAt(), that.getUpdatedAt());
    }

    @Override
    public String toString() {
        return "CommonAgreement{" +
                "id=" + id +
                ", accountId='" + accountId + '\'' +
                ", productId='" + productId + '\'' +
                ", interestRate=" + interestRate +
                ", status=" + status +
                ", sum=" + sum +
                ", currencyCode='" + currencyCode + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAccountId(), getProductId(), getInterestRate(), getStatus(), getSum(), getCurrencyCode(), getCreatedAt(), getUpdatedAt());
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getAccountId() {
        return Arrays.toString(accountId.toCharArray());
    }

    @Override
    public String getProductId() {
        return productId;
    }

    @Override
    public float getInterestRate() {
        return interestRate;
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
    public BigDecimal getSum() {
        return sum;
    }

    @Override
    public String getCurrencyCode() {
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

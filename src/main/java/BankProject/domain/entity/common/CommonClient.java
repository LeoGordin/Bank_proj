package BankProject.domain.entity.common;

import BankProject.domain.entity.interfaces.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CommonClient implements Client {

    private int id;

    private byte[] managerId;

    private int status;

    private String taxCode;

    private String firstName;

    private String lastName;

    private String email;

    private String address;

    private String phone;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    private List<Account> accounts;

    private List<Agreement> agreements;

    private List<Transaction> transactions;

    private List<Manager> managers;

    public CommonClient() {
    }

    public CommonClient
            (
                    int id,
                    byte[] managerId,
                    int status,
                    String taxCode,
                    String firstName,
                    String lastName,
                    String email,
                    String address,
                    String phone,
                    Timestamp createdAt,
                    Timestamp updatedAt,
                    List<Account> accounts,
                    List<Agreement> agreements,
                    List<Transaction> transactions,
                    List<Manager> managers) {
        this.id = id;
        this.managerId = managerId;
        this.status = status;
        this.taxCode = taxCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.accounts = accounts;
        this.agreements = agreements;
        this.transactions = transactions;
        this.managers = managers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommonClient)) return false;
        CommonClient that = (CommonClient) o;
        return getId() == that.getId() &&
                getStatus() == that.getStatus() &&
                Arrays.equals(getManagerId().toCharArray(), that.getManagerId().toCharArray()) &&
                Objects.equals(getTaxCode(), that.getTaxCode()) &&
                Objects.equals(getFirstName(), that.getFirstName()) &&
                Objects.equals(getLastName(), that.getLastName()) &&
                Objects.equals(getEmail(), that.getEmail()) &&
                Objects.equals(getAddress(), that.getAddress()) &&
                Objects.equals(getPhone(), that.getPhone()) &&
                Objects.equals(getCreatedAt(), that.getCreatedAt()) &&
                Objects.equals(getUpdatedAt(), that.getUpdatedAt()) &&
                Objects.equals(getAccounts(), that.getAccounts()) &&
                Objects.equals(getAgreements(), that.getAgreements()) &&
                Objects.equals(getTransactions(), that.getTransactions()) &&
                Objects.equals(getManagers(), that.getManagers());
    }

    @Override
    public int hashCode() {
        int result =
                Objects.hash(getId(), getStatus(), getTaxCode(), getFirstName(), getLastName(), getEmail(), getAddress(), getPhone(), getCreatedAt(), getUpdatedAt(), getAccounts(), getAgreements(), getTransactions(), getManagers());
        result = 31 * result + Arrays.hashCode(getManagerId().toCharArray());
        return result;
    }

    @Override
    public String toString() {
        return "CommonClient{" +
                "id=" + id +
                ", managerId=" + Arrays.toString(managerId) +
                ", status=" + status +
                ", taxCode='" + taxCode + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", accounts=" + accounts +
                ", agreements=" + agreements +
                ", transactions=" + transactions +
                ", managers=" + managers +
                '}';
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getManagerId() {
        return Arrays.toString(managerId);
    }

    @Override
    public int getStatus() {
        return status;
    }

    @Override
    public String getTaxCode() {
        return taxCode;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    @Override
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public List<Account> getAccounts() {
        return accounts;
    }

    @Override
    public List<Agreement> getAgreements() {
        return agreements;
    }

    @Override
    public List<Transaction> getTransactions() {
        return transactions;
    }

    @Override
    public List<Manager> getManagers() {
        return managers;
    }
}

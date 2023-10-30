package BankProject.domain.entity.common;

import BankProject.domain.entity.interfaces.Client;
import BankProject.domain.entity.interfaces.Manager;
import BankProject.domain.entity.interfaces.Product;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

public class CommonManager implements Manager {

    private int id;

    private String firstName;

    private String lastName;

    private int status;

    private String description;

    private Timestamp createdAt;

    List<Client> clients;

    List<Product> products;

    public CommonManager(int id, String firstName, String lastName, int status,
                         String description, Timestamp createdAt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
        this.description = description;
        this.createdAt = createdAt;
    }

    public CommonManager() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommonManager that = (CommonManager) o;
        return id == that.id &&
                status == that.status &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(description, that.description) &&
                Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getStatus(), getDescription(), getCreatedAt(), getClients(), getProducts());
    }

    @Override
    public String toString() {
        return "CommonManager{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", status=" + status +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", clients=" + clients +
                ", products=" + products +
                '}';
    }

    @Override
    public int getId() {
        return id;
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
    public int getStatus() {
        return status;
    }

    @Override
    public String getDescription() {
        return description;
    }


    @Override
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    @Override
    public List<Client> getClients() {
        return clients;
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }
}

package BankProject.domain.entity;

import BankProject.domain.entity.interfaces.ManagerInterface;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "manager")
@NoArgsConstructor
@AllArgsConstructor
public class Manager implements ManagerInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_id")
    @Getter
    @Setter
    private User user;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "status")
    private String status;

    @Column(name = "description")
    private String description;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    @Getter
    @Setter
    private Timestamp updatedAt;

    @OneToMany(mappedBy = "manager")
    private List<Client> clients;

    @OneToMany(mappedBy = "manager")
    private List<Product> products;

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
    public String getStatus() {
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

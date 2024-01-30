package BankProject.domain.entity;

import BankProject.domain.entity.interfaces.ManagerInterface;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

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

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "status")
    private int status;

    @Column(name = "description")
    private String description;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "role")
    private Role role;

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

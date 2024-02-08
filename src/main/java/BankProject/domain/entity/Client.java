package BankProject.domain.entity;

import BankProject.domain.entity.interfaces.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "client")
@NoArgsConstructor
public class Client implements ClientInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_id")
    @Getter
    @Setter
    private int userId;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;

    @Column(name = "status")
    private String status;

    @Column(name = "tax_code")
    private String taxCode;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @OneToMany(mappedBy = "client")
    private List<Account> accounts;

    @OneToMany(mappedBy = "client")
    private List<Transaction> transactions;

    @OneToMany(mappedBy = "client")
    private List<Agreement> agreements;


    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getManagerId() {
        return manager.getId();
    }

    @Override
    public String getStatus() {
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
    public Manager getManager() {
        return manager;
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
}

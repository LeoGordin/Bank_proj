package BankProject.domain.entity.jpa;

import BankProject.domain.entity.interfaces.*;
import BankProject.domain.entity.interfaces.Manager;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "client")
@NoArgsConstructor
@AllArgsConstructor
public class JpaClient implements Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private String managerId;

    @Column(name = "status")
    private int status;

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

    @OneToMany(mappedBy = "account")
    private List<Account> accounts;

    @OneToMany(mappedBy = "agreement")
    private List<Agreement> agreements;

    @OneToMany(mappedBy = "transaction")
    private List<Transaction> transactions;

    @OneToMany(mappedBy = "manager")
    private List<Manager> managers;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getManagerId() {
        return managerId;
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

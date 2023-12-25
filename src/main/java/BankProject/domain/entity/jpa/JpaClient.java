package BankProject.domain.entity.jpa;

import BankProject.domain.entity.interfaces.*;
import BankProject.domain.entity.interfaces.Manager;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private JpaManager manager;

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

    @OneToMany(mappedBy = "client")
    private List<JpaAccount> accounts;

    @OneToMany(mappedBy = "client")
    private List<JpaTransaction> transactions;

    @OneToMany(mappedBy = "client")
    private List<JpaAgreement> agreements;


    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getManagerId() {
        return manager.getId();
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
    public JpaManager getManager() {
        return manager;
    }

    @Override
    public List<JpaAccount> getAccounts() {
        return accounts;
    }

    @Override
    public List<JpaAgreement> getAgreements() {
        return agreements;
    }

    @Override
    public List<JpaTransaction> getTransactions() {
        return transactions;
    }
}

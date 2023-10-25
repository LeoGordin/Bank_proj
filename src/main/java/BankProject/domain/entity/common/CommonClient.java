package BankProject.domain.entity.common;

import BankProject.domain.entity.interfaces.Client;

import java.sql.Timestamp;

public class CommonClient implements Client {
    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getManager_id() {
        return null;
    }

    @Override
    public int getStatus() {
        return 0;
    }

    @Override
    public String getTaxCode() {
        return null;
    }

    @Override
    public String getFirstName() {
        return null;
    }

    @Override
    public String getLastName() {
        return null;
    }

    @Override
    public String getEmail() {
        return null;
    }

    @Override
    public String getAddress() {
        return null;
    }

    @Override
    public String getPhone() {
        return null;
    }

    @Override
    public Timestamp getCreated_at() {
        return null;
    }

    @Override
    public Timestamp getUpdated_at() {
        return null;
    }

    @Override
    public List<Account> getAccounts() {
        return null;
    }
}

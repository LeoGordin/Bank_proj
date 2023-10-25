package BankProject.domain.entity.interfaces;

import java.sql.Timestamp;
import java.util.List;

/**
 * Interface for Bank Client
 * @author Lev Gordin
 * @version 1.0.0
 */

public interface Client {


    int getId();

    String getManagerId();

    int getStatus();

    String getTaxCode();

    String getFirstName();

    String getLastName();

    String getEmail();

    String getAddress();

    String getPhone();

    Timestamp getCreatedAt();

    Timestamp getUpdatedAt();

    List<Account> getAccounts();
}

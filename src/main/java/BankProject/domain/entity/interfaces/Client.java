package BankProject.domain.entity.interfaces;

import java.sql.Timestamp;
import java.util.List;

/**
 * Interface for Bank Client
 * @author Lev Gordin
 * @version 1.0.0
 */

public interface Client {

    /**
     * Retrieves ID of a client
     *
     * @return ID of @Client
     */
    int getId();

    /**
     * Retrieves ID of a client's manager
     *
     * @return ID of @Manager
     */
    String getManagerId();

    /**
     * Retrieves status of manager
     *
     * @return @MANAGER_STATUS of @Manager
     */
    int getStatus();

    /**
     * Retrieves tax code of client
     *
     * @return tax code of @Client
     */
    String getTaxCode();

    /**
     * Retrieves first name of client
     *
     * @return first name of @Client
     */
    String getFirstName();

    /**
     * Retrieves last name of client
     *
     * @return last name of @Client
     */
    String getLastName();

    /**
     * Retrieves email of client
     *
     * @return email of @Client
     */
    String getEmail();

    /**
     * Retrieves address of client
     *
     * @return address of @Client
     */
    String getAddress();

    /**
     * Retrieves phone number of client
     *
     * @return phone number of @Client
     */
    String getPhone();

    /**
     * Retrieves date and time of creation of client
     *
     * @return creation date and time of @Client
     */
    Timestamp getCreatedAt();

    /**
     * Retrieves date and time of last update of client's information
     *
     * @return last update date and time of @Client
     */
    Timestamp getUpdatedAt();

    /**
     * Retrieves list of client's accounts
     *
     * @return list of @Account of @Client
     */
    List<Account> getAccounts();

    /**
     * Retrieves list of client's agreements
     *
     * @return list of @Agreement of @Client
     */
    List<Agreement> getAgreements();

    /**
     * Retrieves list of client's transactions
     *
     * @return list of @Transaction of @Client
     */
    List<Transaction> getTransactions();

    /**
     * Retrieves list of Client's managers
     *
     * @return list of @Manager of @Client
     */
    List<Manager> getManagers();
}

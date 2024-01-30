package BankProject.domain.entity.interfaces;

import BankProject.domain.entity.Account;
import BankProject.domain.entity.Agreement;
import BankProject.domain.entity.Manager;
import BankProject.domain.entity.Transaction;

import java.sql.Timestamp;
import java.util.List;

/**
 * Interface for Bank Client
 * @author Lev Gordin
 * @version 1.0.0
 */

public interface ClientInterface {

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
    int getManagerId();

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
     * Retrieves manager of client
     *
     * @return @JpaManager of @JpaClient
     */
    Manager getManager();

    /**
     * Retrieves list of client's accounts
     *
     * @return list of @JpaAccount of @JpaClient
     */
    List<Account> getAccounts();

    /**
     * Retrieves list of client's agreements
     *
     * @return list of @JpaAgreement of @JpaClient
     */
    List<Agreement> getAgreements();

    /**
     * Retrieves list of client's transactions
     *
     * @return list of @JpaTransaction of @JpaClient
     */
    List<Transaction> getTransactions();

}

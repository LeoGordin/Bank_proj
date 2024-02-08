package BankProject.domain.entity.interfaces;

import BankProject.domain.entity.Client;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

/**
 * Interface for Bank Account
 *
 * @Author Lev Gordin
 * @Version 1.0.0
 */

public interface AccountInterface {

    /**
     * Retrieves ID of a bank account
     *
     * @return ID of @Account
     */
    int getId();

    /**
     * Retrieves ID of a bank account's owner (@Client)
     *
     * @return ID of @Client
     */
    int getClientId();

    /**
     * Retrieves name of a bank account
     *
     * @return ID of @Account
     */
    java.lang.String getName();


    /**
     * Retrieves type of bank account
     *
     * @return type of @Account
     */
    java.lang.String getType();

    /**
     * Sets type of bank account
     *
     * sets @ACCOUNT_TYPE of @Account
     */
    void setType(String type);



    /**
     * Retrieves status of bank account
     *
     * @return @ACCOUNT_STATUS of @Account
     */
    java.lang.String getStatus();

    /**
     * Sets status of a bank account
     * <p>
     * sets @ACCOUNT_STATUS of @Account
     */
    void setStatus(java.lang.String status);

    /**
     * Retrieves balance of a bank account
     *
     * @return balance of @Account
     */
    BigDecimal getBalance();

    /**
     * Retrieves currency of a bank account
     *
     * @return currency of @Account
     */
    String getCurrency();

    /**
     * Retrieves date and time of creation of a bank account
     *
     * @return @Account creation moment using @Timestamp
     */
    Timestamp getCreatedAt();

    /**
     * Retrieves date and time of last update of a bank account
     *
     * @return @Account last update moment using @Timestamp
     */
    Timestamp getUpdatedAt();

    void setBalance(BigDecimal balance);


    Client getClient();
}

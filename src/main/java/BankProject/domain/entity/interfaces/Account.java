package BankProject.domain.entity.interfaces;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Interface for Bank Account
 *
 * @Author Lev Gordin
 * @Version 1.0.0
 */

public interface Account {

    /**
     * Retrieves ID of a bank account
     *
     * @return ID of @Account
     */
    String getId();

    /**
     * Retrieves ID of a bank account's owner (@Client)
     *
     * @return ID of @Client
     */
    String getClientId();

    /**
     * Retrieves name of a bank account
     *
     * @return ID of @Account
     */
    String getName();

    /**
     * Retrieves status of bank account
     *
     * @return @ACCOUNT_STATUS of @Account
     */
    int getStatus();

    /**
     * Sets status of a bank account
     * <p>
     * sets @ACCOUNT_STATUS of @Account
     */
    void setStatus(int status);

    /**
     * Retrieves balance of a bank account
     *
     * @return balance of @Account
     */
    BigDecimal getBalance();

    /**
     * Retrieves currency code of a bank account
     *
     * @return currency of @Account
     */
    int getCurrencyCode();

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
}

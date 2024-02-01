package BankProject.domain.entity.interfaces;

import BankProject.domain.entity.Client;
import BankProject.domain.entity.enums.AccountStatus;
import BankProject.domain.entity.enums.AccountType;
import BankProject.domain.entity.enums.Currency;

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
    UUID getId();

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
    String getName();


    /**
     * Retrieves type of bank account
     *
     * @return type of @Account
     */
    AccountType getType();

    /**
     * Sets type of bank account
     *
     * sets @ACCOUNT_TYPE of @Account
     */
    void setType(AccountType type);



    /**
     * Retrieves status of bank account
     *
     * @return @ACCOUNT_STATUS of @Account
     */
    AccountStatus getStatus();

    /**
     * Sets status of a bank account
     * <p>
     * sets @ACCOUNT_STATUS of @Account
     */
    void setStatus(AccountStatus status);

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
    Currency getCurrency();

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

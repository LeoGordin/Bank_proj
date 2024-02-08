package BankProject.domain.entity.interfaces;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

/**
 * Interface for Bank Transaction
 * @author Lev Gordin
 * @version 1.0.0
 */

public interface TransactionInterface {

    /**
     * Retrieves ID of the transaction
     *
     * @return ID of @Transaction
     */
    int getId();

    /**
     * Retrieves ID of the credit (sender) account
     *
     * @return ID of credit @Account
     */
    int getCreditAccountId();

    /**
     * Retrieves ID of the debit (recipient) account
     *
     * @return ID of debit @Account
     */
    int getDebitAccountId();

    /**
     * Retrieves type of transaction
     *
     * @return @TRANSACTION_TYPE of @Transaction
     */
    String getType();

    /**
     * Retrieves amount of transaction
     *
     * @return amount of @Transaction
     */
    BigDecimal getAmount();

    /**
     * Retrieves description of transaction
     *
     * @return description of @Transaction
     */
    String getDescription();

    Timestamp getCreatedAt();
}

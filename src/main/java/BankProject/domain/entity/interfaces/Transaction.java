package BankProject.domain.entity.interfaces;

import java.math.BigDecimal;

/**
 * Interface for Bank Transaction
 * @author Lev Gordin
 * @version 1.0.0
 */

public interface Transaction {

    /**
     * Retrieves ID of the transaction
     *
     * @return ID of @Transaction
     */
    String getId();

    /**
     * Retrieves ID of the credit (sender) account
     *
     * @return ID of credit @Account
     */
    String getCreditAccountId();

    /**
     * Retrieves ID of the debit (recipient) account
     *
     * @return ID of debit @Account
     */
    String getDebitAccountId();

    /**
     * Retrieves type of transaction
     *
     * @return @TRANSACTION_TYPE of @Transaction
     */
    int getType();

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
}

package BankProject.domain.entity.interfaces;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * Interface for Agreement
 * @author Lev Gordin
 * @version 1.0.0
 */

public interface Agreement {

    /**
     * Returns ID of the agreement (between Bank and Client)
     * @return ID of @Agreement
     */
    UUID getId();

    /**
     * Returns ID of an account, used in agreement
     *
     * @return ID of @Account
     */
    String getAccountId();

    /**
     * Returns ID of a product, used in agreement
     *
     * @return ID of @Product
     */
    String getProductId();

    /**
     * Returns interest rate of the agreement
     *
     * @return interest rate of @Agreement
     */
    float getInterestRate();

    /**
     * Returns status of agreement
     *
     * @return @AGREEMENT_STATUS (value) of @Agreement
     */
    int getStatus();

    /**
     * Sets status of an agreement
     *
     * Sets @AGREEMENT_STATUS of @Agreement
     */
    void setStatus(int status);

    /**
     * Retrieves sum of the agreement
     *
     * @return sum of @Agreement
     */
    BigDecimal getSum();

    /**
     * Retrieves currency code of the agreement
     *
     * @return @CURRENCY_CODE of @Agreement
     */
    String getCurrencyCode();

    /**
     * Retrieves creation date and time of the agreement
     *
     * @return creation date and time of @Agreement
     */
    Timestamp getCreatedAt();

    /**
     * Retrieves last update date and time of the agreement
     *
     * @return last update date and time of @Agreement
     */
    Timestamp getUpdatedAt();


    int getClientId();
}

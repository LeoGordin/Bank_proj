package BankProject.domain.entity.interfaces;

import BankProject.domain.entity.Client;
import BankProject.domain.entity.enums.AgreementStatus;
import BankProject.domain.entity.enums.Currency;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

/**
 * Interface for Agreement
 * @author Lev Gordin
 * @version 1.0.0
 */

public interface AgreementInterface {

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
    UUID getAccountId();

    /**
     * Returns ID of a product, used in agreement
     *
     * @return ID of @Product
     */
    int getProductId();

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
    AgreementStatus getStatus();

    /**
     * Sets status of an agreement
     *
     * Sets @AGREEMENT_STATUS of @Agreement
     */
    void setStatus(AgreementStatus status);

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
    Currency getCurrency();

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

    void setClient(Client client);
}

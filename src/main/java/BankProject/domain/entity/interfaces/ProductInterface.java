package BankProject.domain.entity.interfaces;

import BankProject.domain.entity.enums.Currency;
import BankProject.domain.entity.enums.ProductStatus;

import java.math.BigDecimal;
import java.sql.Timestamp;

public interface ProductInterface {

    /**
     * Retrieves ID of a product
     *
     * @return ID of @Product
     */
    int getId();

    /**
     * Retrieves ID of manager, responsible for this product
     *
     * @return ID of @Manager
     */
    int getManagerId();

    /**
     * Retrieves name of product
     *
     * @return name of @Product
     */
    String getName();

    /**
     * Retrieves status of product
     *
     * @return @PRODUCT_STATUS of @Product
     */
    ProductStatus getStatus();

    /**
     * Retrieves currency code of product
     *
     * @return @CURRENCY_CODE of @Product
     */
    Currency getCurrency();

    /**
     * Retrieves interest rate of product
     *
     * @return interest rate of @Product
     */
    BigDecimal getInterestRate();

    /**
     * Retrieves limit of product
     *
     * @return limit of @Product
     */
    BigDecimal getLimit();

    /**
     * Retrieves creation date and time of product
     *
     * @return creation date and time of @Product
     */
    Timestamp getCreatedAt();

    /**
     * Retrieves last update date and time of product
     *
     * @return last update date and time of @Product
     */
    Timestamp getUpdatedAt();
}

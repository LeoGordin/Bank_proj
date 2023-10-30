package BankProject.domain.entity.interfaces;

import java.sql.Timestamp;
import java.util.List;

/**
 * Interface for Bank Manager
 * @author Lev Gordin
 * @version 1.0.0
 */

public interface Manager {

    /**
     * Retrieves ID of a manager
     *
     * @return ID of @Manager
     */
    int getId();

    /**
     * Retrieves first name of manager
     *
     * @return first name of @Manager
     */
    String getFirstName();

    /**
     * Retrieves last name of manager
     *
     * @return last name of @Manager
     */
    String getLastName();

    /**
     * Retrieves status of manager
     *
     * @return @MANAGER_STATUS of @Manager
     */
    int getStatus();

    /**
     * Retrieves description of manager
     *
     * @return
     */
    String getDescription();


    /**
     * Retrieves creation date and time of manager's record
     *
     * @return creation date and time of @Manager
     */
    Timestamp getCreatedAt();

    /**
     * Retrieves last update date and time of manager's record
     *
     * @return last update date and time of @Manager
     */
    List<Client> getClients();

    /**
     * Retrieves manager's list of products
     *
     * @return @Product list of @Manager
     */
    List<Product> getProducts();
}

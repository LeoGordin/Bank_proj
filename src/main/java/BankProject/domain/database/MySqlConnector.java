package BankProject.domain.database;

import BankProject.constants.Constants;

import java.sql.Connection;
import java.sql.DriverManager;

import static BankProject.constants.Constants.DB_DRIVER_PATH;

public class MySqlConnector {

    public static Connection getConnection() {
        try {
            Class.forName(DB_DRIVER_PATH);
            String dbUrl = Constants.DB_ADDRESS + Constants.DB_NAME;
            return DriverManager.getConnection(dbUrl, Constants.DB_USER_NAME, Constants.DB_PASSWORD);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

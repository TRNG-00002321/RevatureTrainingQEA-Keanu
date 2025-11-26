package com.revature.expense.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    private static Connection connection;
    private final Logger logger = LoggerFactory.getLogger(ConnectionUtil.class);

    //Private constructor for singleton class
    private ConnectionUtil(){

        //get url info from properties file
        String url = "";
        String user = "";
        String password = "";

        //connect to database
        try{
            connection = DriverManager.getConnection(url, user, password);
            logger.info("Database connected successfully");
        } catch (SQLException e) {
            //Handle database error exception
            System.err.println("Error connecting to database: " + e.getMessage());
            logger.error("Database connection failed");
        }
    }

    //Instance holder for connectionUtil
    private static final class InstanceHolder {
        private static final ConnectionUtil instance = new ConnectionUtil();
    }

    //Gets singleton instance of class
    public static ConnectionUtil getInstance(){

        return InstanceHolder.instance;
    }

    //Get connection to database
    public Connection getConnection(){return connection;}

    //Close database connection
    public void closeConnection(){
        if(connection != null){
            try{
                connection.close();
            } catch (SQLException e) {
                System.err.println("Error closing database: " + e.getMessage());
                logger.error("Failed to close database");
            }
        }
    }
}

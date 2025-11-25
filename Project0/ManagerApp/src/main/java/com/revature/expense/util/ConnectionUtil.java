package com.revature.expense.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    public static Connection dbConnection(){
        Connection connection = null;

        try{
            connection = DriverManager.getConnection("placeholder");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }

}

package com.revature.daodemo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    public static Connection dbConnection() throws SQLException {

        Connection connection = null;
        try {
            connection = DriverManager.getConnection("example");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
}

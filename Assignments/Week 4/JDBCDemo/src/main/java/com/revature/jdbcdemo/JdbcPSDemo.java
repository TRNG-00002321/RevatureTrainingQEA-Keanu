package com.revature.jdbcdemo;

import java.sql.*;

public class JdbcPSDemo {
    static void main() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{

            //Step 2 create the connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels",
                    "root","ppp444");

            String insertQuery = "INSERT INTO contacts(name, email, phone) values(?,?,?)";

            preparedStatement = connection.prepareStatement(insertQuery);

            preparedStatement.setString(1,"Keanu");
            preparedStatement.setString(2,"keanu@gmail.com");
            preparedStatement.setString(3,"1234567890");

            preparedStatement.execute();
            preparedStatement.close();

            String selectQuery = "SELECT * FROM concacts WHERE name LIKE ?";
            preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setString(1,"Keanu");

            resultSet = preparedStatement.executeQuery();

            while(resultSet.next())
            {
                System.out.println(resultSet.getInt("id") + " , " + resultSet.getString(2));
            }

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

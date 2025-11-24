package com.revature.jdbcdemo;
import java.sql.*;

public class JdbcStmt01 {
    static void main() throws ClassNotFoundException {

        Statement statement = null;
        ResultSet resultSet = null;
        //Step 1 load the driver
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Step 2 create the connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels",
                    "root","pass444");

            // Step 3 Create the statement object
            statement = connection.createStatement();
            String selectQuery = "SELECT * FROM CONTACTS";

            //Step 4 Execute the query and collect the result in result set
            resultSet = statement.executeQuery(selectQuery);

            // Step 5 Process the result set
            while(resultSet.next()){
                System.out.println(resultSet.getInt("id") + " , " + resultSet.getString(2));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Database Connected");
    }
}

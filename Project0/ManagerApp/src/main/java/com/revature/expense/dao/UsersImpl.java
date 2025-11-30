package com.revature.expense.dao;

import com.revature.expense.model.Users;
import com.revature.expense.util.ConnectionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class UsersImpl implements UsersDAO{
    //Get singleton connection utility class
    private final ConnectionUtil connectionUtil = ConnectionUtil.getInstance();
    private final Logger logger = LoggerFactory.getLogger(UsersImpl.class);

    //Add new user to Users table
    @Override
    public void addUser(String username, String password){
        PreparedStatement preparedStatement = null;

        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/expensesDB", "root", "ppp444")){

            //create an insert statement
            String query = "INSERT INTO users (username, password, role) VALUES(?,?,?)";
            preparedStatement = conn.prepareStatement(query);

            //Set dynamic query values
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, "manager");

            //Execute then close statement
            preparedStatement.execute();
        }catch (SQLException e){
            System.out.println("Account creation failed!");
            logger.error("User not found:{}", e.getMessage());
        }
    }

    //Login function finds and returns a user if none found return null
    @Override
    public Users login(String username, String password) {
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        Users user = null;

        //Connect to database
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/expensesDB", "root", "ppp444")) {
            String query = "SELECT * FROM users " +
                            "WHERE username LIKE ? AND password LIKE ?";

            //SELECT query to retrieve user
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2,password);

            result = preparedStatement.executeQuery();

            //create user object if result found
            if(result.next()){
                user = new Users(result.getInt("id"), result.getString("username"),
                        result.getString("password"), result.getString("role"));
            }

            //return user object
            return user;
        } catch (SQLException e) {
            System.out.println("Invalid Login");
            logger.warn("User not found:{}", e.getMessage());
        }

        //return null by default
        return null;
    }
}

package com.revature.expense.dao;

import com.revature.expense.model.Users;
import com.revature.expense.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsersImpl implements UsersDAO{
    //Get singleton connection utility class
    private static final ConnectionUtil connectionUtil = ConnectionUtil.getInstance();

    //Add new user to Users table
    @Override
    public void addUser(String username, String password) throws SQLException {
        PreparedStatement preparedStatement = null;

        try(Connection conn = connectionUtil.getConnection()){

            //create an insert statement
            String query = "INSERT INTO users (username, password, role) VALUES(?,?,?)";
            preparedStatement = conn.prepareStatement(query);

            //Set dynamic query values
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, "manager");

            //Execute then close statement
            preparedStatement.execute();
            preparedStatement.close();
        }
    }

    //Login function finds and returns a user if none found return null
    @Override
    public Users login(String username, String password) {
        return null;
    }
}

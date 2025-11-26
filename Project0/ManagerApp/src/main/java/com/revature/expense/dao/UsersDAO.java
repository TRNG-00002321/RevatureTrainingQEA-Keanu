package com.revature.expense.dao;

import com.revature.expense.model.Users;

import java.sql.SQLException;

public interface UsersDAO {

    public void addUser(String username, String password) throws SQLException;
    public Users login(String username, String password);

}

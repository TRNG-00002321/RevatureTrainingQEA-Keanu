package com.revature.expense;

import com.revature.expense.dao.UsersDAO;
import com.revature.expense.dao.UsersImpl;

import java.sql.SQLException;

public class Main {
    static void main() throws SQLException {
        UsersDAO usersDAO = new UsersImpl();

        usersDAO.addUser("Keanu", "password123");

    }
}

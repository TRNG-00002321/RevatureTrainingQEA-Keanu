package com.revature.daodemo.dao;

import com.revature.daodemo.model.Contacts;
import com.revature.daodemo.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactsJDBCImpl implements ContactDAO{
    Connection connection = null;

    public Contacts getContact(int id) {
        connection = ConnectionUtil.dbConnection();
        Contacts contacts = null;

        String getContact = "SELECT * FROM contacts WHERE id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(getContact);
        preparedStatement.setInt(1,2);
        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()){
            contacts = new Contacts(resultSet.getInt(1), resultSet.getString(2)
            , resultSet.getString(3));
        }

        return contacts;
    }
}

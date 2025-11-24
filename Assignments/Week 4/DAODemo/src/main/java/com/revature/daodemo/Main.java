package com.revature.daodemo;

import com.revature.daodemo.dao.ContactDAO;
import com.revature.daodemo.dao.ContactsJDBCImpl;

import java.sql.Connection;

public class Main {
    static Connection connection = null;

    static void main() {
        //connection ConnectionUtil.
        ContactDAO contactDAO = new ContactsJDBCImpl();
       // Contact contact = contactDAO.getContact(2);
    }
}

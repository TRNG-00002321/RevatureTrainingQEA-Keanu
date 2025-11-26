package com.revature.daodemo.dao;

import com.revature.daodemo.model.Contacts;

import java.sql.SQLException;
import java.util.List;

public interface ContactDAO {
    public default List<Contacts> getAllContacts(){
        System.out.println("Default");
        return null;
    }
    public default Contacts getContact(int id) throws SQLException {
        return null;
    }
    public default void save(Contacts contacts){}
    public default Contacts update(int id){return null;}
    public default void delete(int id){}
}

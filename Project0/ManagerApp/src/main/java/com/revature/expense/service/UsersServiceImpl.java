package com.revature.expense.service;

import com.revature.expense.dao.UsersDAO;
import com.revature.expense.dao.UsersImpl;
import com.revature.expense.model.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class UsersServiceImpl implements UsersService{
    private final UsersDAO usersDAO = new UsersImpl();
    private static Users manager = null;
    private final Logger logger = LoggerFactory.getLogger(UsersServiceImpl.class);

    @Override
    public boolean Login() {
        Scanner sc = new Scanner(System.in);

        //get user input for username
        System.out.println("======Log In======");
        System.out.println("Username: ");
        String username = sc.nextLine();

        //get user input for password
        System.out.println("Password: ");
        String password = sc.nextLine();

        //get current manager user object with login function
        manager = usersDAO.login(username, password);

        //if manager account exists then login otherwise return false
        if(manager != null){
            System.out.println("Login Successful");
            logger.info("User: {} Logged in", manager.getUsername());
            return true;
        }
        else{
            System.out.println("Incorrect Login Credentials");
            logger.info("User login failed");
            return false;
        }
    }

    //gets current manager user object
    public static Users getManager() {
        return manager;
    }

    @Override
    public void CreateAccount() {
        Scanner sc = new Scanner(System.in);

        //gets user input for new account username
        System.out.println("======Create Account======");
        System.out.println("New Username: ");
        String username = sc.nextLine();

        //gets user input for new account password
        System.out.println("New Password: ");
        String password = sc.nextLine();

        //create user account
        usersDAO.addUser(username, password);
    }
}

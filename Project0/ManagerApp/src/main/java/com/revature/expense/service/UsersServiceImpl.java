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

        System.out.println("======Log In======");
        System.out.println("Username: ");
        String username = sc.nextLine();

        System.out.println("Password: ");
        String password = sc.nextLine();

        manager = usersDAO.login(username, password);

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

    public static Users getManager() {
        return manager;
    }

    @Override
    public void CreateAccount() {
        Scanner sc = new Scanner(System.in);

        System.out.println("======Create Account======");
        System.out.println("New Username: ");
        String username = sc.nextLine();

        System.out.println("New Password: ");
        String password = sc.nextLine();

        usersDAO.addUser(username, password);
    }
}

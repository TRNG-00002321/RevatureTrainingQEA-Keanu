package com.revature.bank;

//Create a new maven project
//Depicting or simulating a mini bank application
//In the bank there are 2 types of accounts - savings and checking accounts
//The attributes of both of these saving and checking accounts are:
//AccountID
//AccountName
//Balance

//The checking account has a surcharge of .01% while withdrawing
//both have methods withdraw and deposit

//Interest in the balance amount is 5% is applicable on the savings account


public abstract class BankAccount {

    private String accountID;
    private String accountName;
    private double balance;

    public BankAccount() {
    }

    public BankAccount(String accountID, String accountName, double balance) {
        this.accountID = accountID;
        this.accountName = accountName;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountID='" + accountID + '\'' +
                ", accountName='" + accountName + '\'' +
                ", balance=" + balance +
                '}';
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double deposit(double amount){
        return balance += amount;
    }

    public abstract double withdraw(double amount);
}

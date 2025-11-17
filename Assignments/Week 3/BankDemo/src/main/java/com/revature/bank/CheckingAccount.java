package com.revature.bank;

public class CheckingAccount extends BankAccount{
    public CheckingAccount() {
    }

    public CheckingAccount(String accountID, String accountName, double balance) {
        super(accountID, accountName, balance);
    }

    @Override
    public String toString() {
        return "CheckingAccount{} " + super.toString();
    }

    @Override
    public double withdraw(double amount) {
        double surcharge = (amount * 0.01)/100;
        amount += surcharge;

        double balance = super.getBalance();
        balance -= amount;
        super.setBalance(balance);
        return balance;
    }



}

package com.revature.bank;

public class SavingsAccount extends BankAccount implements SimpleInterest{
    public SavingsAccount() {
    }

    public SavingsAccount(String accountID, String accountName, double balance) {
        super(accountID, accountName, balance);
    }

    @Override
    public String toString() {
        return "SavingsAccount{} " + super.toString();
    }

    @Override
    public double withdraw(double amount) {
        double balance = super.getBalance();
        balance -= amount;
        super.setBalance(balance);
        return balance;
    }

    @Override
    public double calculateInterest(double percentage) {
        double balance = super.getBalance();
        double interest = (balance * percentage);
        balance += interest;

        super.setBalance(balance);
        return balance;
    }
}

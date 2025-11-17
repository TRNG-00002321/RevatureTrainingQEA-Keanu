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
    public double withdraw(double amount) throws InvalidAmountException, IllegalArgumentException {

        if(amount < 5000)
            throw new InvalidAmountException("Amount must be 5000 or more");
        else if (amount < 0)
            throw new IllegalArgumentException("Amount must be non-negative!!!");
        else{
            double surcharge = (amount * 0.01)/100;
            amount += surcharge;

            double balance = super.getBalance();
            balance -= amount;
            super.setBalance(balance);
            return balance;
        }
    }



}

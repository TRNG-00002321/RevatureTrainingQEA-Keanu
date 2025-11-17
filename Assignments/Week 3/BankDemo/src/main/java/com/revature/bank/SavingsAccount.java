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
    public double withdraw(double amount) throws InvalidAmountException, IllegalArgumentException {

        if(amount < 5000)
            throw new InvalidAmountException("Amount must be 5000 or more");
        else if (amount < 0)
            throw new IllegalArgumentException("Amount must be non-negative!!!");
        else{

            double balance = super.getBalance();
            balance -= amount;
            super.setBalance(balance);
            return balance;
        }
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

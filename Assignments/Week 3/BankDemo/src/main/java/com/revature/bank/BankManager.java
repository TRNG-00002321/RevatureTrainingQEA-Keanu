package com.revature.bank;

public class BankManager {
    public static void main(String[] args){
        SavingsAccount savingsAccount1 = new
                SavingsAccount("5001","Bob",30000);
        CheckingAccount checkingAccount1 = new
                CheckingAccount("4001", "Joe", 20000);
        CheckingAccount checkingAccount2 = new
                CheckingAccount("2001","Keanu",2000);

        checkingAccount2.deposit(5000);
        savingsAccount1.withdraw(5000);
        checkingAccount1.withdraw(10000);

        savingsAccount1.calculateInterest(0.05);

        System.out.println(savingsAccount1);
        System.out.println(checkingAccount1);
        System.out.println(checkingAccount2);
    }
}

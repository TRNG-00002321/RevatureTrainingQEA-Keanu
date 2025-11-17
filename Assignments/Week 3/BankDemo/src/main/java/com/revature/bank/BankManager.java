package com.revature.bank;

//if balance is less than 5000 then you cannot withdraw - custom exception
//also handle input exceptions, cannot deposit or withdraw negative values

public class BankManager {
    public static void main(String[] args){
        SavingsAccount savingsAccount1 = new
                SavingsAccount("5001","Bob",30000);
        CheckingAccount checkingAccount1 = new
                CheckingAccount("4001", "Joe", 20000);
        CheckingAccount checkingAccount2 = new
                CheckingAccount("2001","Keanu",2000);
        CheckingAccount errorCheckingAccount = new
                CheckingAccount("4004","Error",500);

        checkingAccount2.deposit(5000);
        savingsAccount1.withdraw(5000);
        checkingAccount1.withdraw(10000);

        //testing exceptions
        try{
            errorCheckingAccount.deposit(-500);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        } catch (InvalidAmountException e){
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println(errorCheckingAccount);
        }

        savingsAccount1.calculateInterest(0.05);

        System.out.println(savingsAccount1);
        System.out.println(checkingAccount1);
        System.out.println(checkingAccount2);
    }
}

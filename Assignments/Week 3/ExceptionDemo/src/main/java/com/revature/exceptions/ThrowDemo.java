package com.revature.exceptions;

//Throw keyword is used to manually throw an exception based on a condition
//Throws keyword is used with the method signature with the exception type
//to tell that the method throws an exception
//Throws is an indicator that a method may or may not throw an exception
public class ThrowDemo {
    public static void validateAge(int age) throws InvalidAgeException{
        if(age<18)
            throw new ArithmeticException("Invalid Age");
        else
            System.out.println("You can vote");
    }

    public static void main(String[] args)
    {
        int age = 8;

        try
        {
            validateAge(age);
        }
        catch (InvalidAgeException e)
        {
            e.printStackTrace();
            //System.out.println(e.getMessage());
            //throw new RuntimeException(e);
        }
    }
}

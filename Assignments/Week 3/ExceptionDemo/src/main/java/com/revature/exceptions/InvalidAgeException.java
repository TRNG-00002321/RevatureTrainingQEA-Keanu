package com.revature.exceptions;

//custom exceptions just create a class and extend any exception type you want

//What is the difference between final, finally, and finalize?
//if balance is less than 5000 then you cannot withdraw - custom exception
//also handle input exceptions, cannot deposit or withdraw negative values

public class InvalidAgeException extends Exception{

    @Override
    public String getMessage() {
        return "Invalid age";
    }
}

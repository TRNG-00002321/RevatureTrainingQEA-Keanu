package com.revature.bank;

//An interface having one and only one abstract method is known as a functional interface
//and facilitates functional programming by using lambda methods
//Single-Abstract-Method Interface

//An interface without any abstract method is known as marker interface
//Simply marks something like a type
//examples: Serializable, Remote

public interface SimpleInterest {
    public double calculateInterest(double percentage);
}

//Assignment: Create a mini project to simulate employee management
//There are 2 categories of employees - salaried and contractual employees
//Salary is calculated based on the number of days present
//For contractual employee it is based on number of hours worked
//Salaried employees are provided with some benefits like food coupons
//Declare variables and calculate salary

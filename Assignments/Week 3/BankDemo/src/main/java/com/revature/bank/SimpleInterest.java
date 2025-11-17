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

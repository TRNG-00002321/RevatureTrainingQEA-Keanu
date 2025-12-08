package com.revature.demo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorSubtractTest {
    static Calculator calculator = null;

    @Test
    void testSubtract(){
        //Arrange
        int n1 = 10;
        int n2 = 5;
        int expectedResult = 5;
        int actualResult;

        //Act
        actualResult = calculator.subtract(n1,n2);

        //Assert
        assertEquals(expectedResult, actualResult);
    }

    @BeforeAll
    public static void setupClass(){
        calculator = new Calculator();
        System.out.println("Before All method is called...");
    }

    @AfterAll
    public static void teardownClass(){
        System.out.println("After All Method is called...");
    }
}

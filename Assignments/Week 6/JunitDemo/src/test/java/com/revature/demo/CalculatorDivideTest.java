package com.revature.demo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorDivideTest {
    static Calculator calculator = null;

    @Test
    void testDivide(){
        //Arrange
        int n1 = 10;
        int n2 = 5;
        int expectedResult = 2;
        int actualResult;

        //Act
        actualResult = calculator.divide(n1,n2);

        //Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testDivideByZero(){
        //Arrange
        int n1 = 10;
        int n2 = 0;


        //Act
        java.lang.IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                ()->calculator.divide(n1,n2));

        //Assert
        assertEquals("Cannot divide by zero", thrownException.getMessage());
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

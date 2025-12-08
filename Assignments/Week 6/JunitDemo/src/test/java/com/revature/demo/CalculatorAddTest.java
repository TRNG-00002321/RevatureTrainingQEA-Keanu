package com.revature.demo;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CalculatorAddTest {

    static Calculator calculator = null;
    @Test
    @DisplayName("Testing Add Methods.... Positive")
    @Disabled
    @Order(1)
    void testAdd(){
        //Arrange
        int n1 = 10;
        int n2 = 12;
        int expectedResult = 22;
        int actualResult;

        //Act
        actualResult = calculator.add(n1,n2);
        System.out.println("Test add setup");

        //Assert
        assertEquals(expectedResult, actualResult, "Test case failed");
    }

    @Test
    @DisplayName("Testing Add Methods.... Negative")
    void testAddNegative(){
        //Arrange
        int n1 = -10;
        int n2 = 12;
        int expectedResult = 2;
        int actualResult;

        //Act
        actualResult = calculator.add(n1,n2);
        System.out.println("Test add negative setup");

        //Assert
        assertEquals(expectedResult, actualResult);
    }

    @BeforeEach
    public void setUp(){
        System.out.println("This is the setup method .... BeforeEach");
    }

    @AfterEach
    public void tearDown(){
        System.out.println("This is the tear down method .... AfterEach");
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

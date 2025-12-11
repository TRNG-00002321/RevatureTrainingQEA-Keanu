import com.revature.first_junit_tests.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTests {

    Calculator calculator;

    @BeforeEach
    void setup(){
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Test Adding 2 Positive Numbers")
    void test_add_positive_numbers(){
        assertEquals(8, calculator.add(5,3), "Result should be 8");
    }

    @Test
    @DisplayName("Test Adding Positive and Negative Numbers")
    void test_add_positive_and_negative_numbers(){
        assertEquals(3, calculator.add(10,-7), "Result should be 3");
    }

    @Test
    @DisplayName("Test Adding 2 Negative Numbers")
    void test_add_negative_numbers(){
        assertEquals(-8, calculator.add(-5,-3), "Result should be negative");
    }

    @Test
    @DisplayName("Test Adding Zero")
    void test_add_zero(){
        assertEquals(42, calculator.add(42,0), "Result should be 42");
    }

    @Test
    @DisplayName("Test Basic Subtraction")
    void test_sub(){
        assertEquals(6, calculator.subtract(10,4), "Result should be 6");
    }

    @Test
    @DisplayName("Test Negative Subtraction")
    void test_sub_negative(){
        assertEquals(-6, calculator.subtract(3,9), "Result should be -6");
    }

    @Test
    @DisplayName("Test Zero Subtraction")
    void test_sub_zero(){
        assertEquals(3, calculator.subtract(3,0), "Result should be 3");
    }

    @Test
    @DisplayName("Test isEven With Positive Numbers")
    void test_isEven_positive_numbers(){
        assertTrue(calculator.isEven(4), "Result should be True");
    }

    @Test
    @DisplayName("Test isEven With Odd Numbers")
    void test_isEven_odd_numbers(){
        assertFalse(calculator.isEven(3), "Result should be False");
    }

    @Test
    @DisplayName("Test isEven With Zero")
    void test_isEven_zero(){
        assertTrue(calculator.isEven(0), "Result should be True");
    }

    @Test
    @DisplayName("Test isEven With Negative Numbers")
    void test_isEven_negative(){
        assertTrue(calculator.isEven(-2), "Result should be True");
    }

    @Test
    @DisplayName("Test isPositive With Positive Numbers")
    void test_isPositive_positive_numbers(){
        assertTrue(calculator.isPositive(5), "Result should be True");
    }

    @Test
    @DisplayName("Test isPositive With Negative Numbers")
    void test_isPositive_negative_numbers(){
        assertFalse(calculator.isPositive(-5), "Result should be False");
    }

    @Test
    @DisplayName("Test isPositive With Zero")
    void test_isPositive_zero(){
        assertFalse(calculator.isPositive(0), "Result should be False");
    }

}

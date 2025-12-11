import com.revature.first_junit_tests.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class ParameterizedCalculatorTests {
    Calculator calculator;

    @BeforeEach
    void setup(){
        calculator = new Calculator();
    }

    @ParameterizedTest(name="{0} is Even")
    @DisplayName("Test isEven Even Numbers With Value Source")
    @ValueSource(ints = {2, 4, 6, 100, 0, -2})
    void isEven_evenNumbers_returnsTrue(int number) {
        assertTrue(calculator.isEven(number));
    }

    @ParameterizedTest(name="{0} is Odd")
    @DisplayName("Test isEven Odd Numbers With Value Source")
    @ValueSource(ints = {3, 5, 7, 101, -1, -3})
    void isEven_oddNumbers_returnsFalse(int number) {
        assertFalse(calculator.isEven(number));
    }

    @ParameterizedTest(name="{0} is Positive")
    @DisplayName("Test isPositive Positive Numbers With Value Source")
    @ValueSource(ints = {1, 100, 5})
    void isPositive_positiveNumbers_returnsTrue(int number) {
        assertTrue(calculator.isPositive(number));
    }

    @ParameterizedTest(name="{0} + {1} = {2}")
    @DisplayName("Test Add from CSV source")
    @CsvSource({
            "1,2,3",
            "0,0,0",
            "-1,1,0",
            "100,200,300",
            "-50,-50,-100",
            "5,0,5"
    })
    void add_variousInputs_returnsCorrectSum(int a, int b, int expected) {
        assertEquals(expected, calculator.add(a, b));
    }

    @ParameterizedTest(name="{0} - {1} = {2}")
    @DisplayName("Test Subtract from CSV source")
    @CsvSource({
            "2,1,1",
            "0,0,0",
            "1,3,-2",
            "-5,-5,0",
    })
    void subtract_variousInputs_returnsCorrectSum(int a, int b, int expected) {
        assertEquals(expected, calculator.subtract(a, b));
    }

    @ParameterizedTest(name="{0} * {1} = {2}")
    @DisplayName("Test Multiply from CSV source")
    @CsvSource({
            "2,1,2",
            "0,0,0",
            "-1,3,-3",
            "-5,-5,25",
    })
    void multiply_variousInputs_returnsCorrectSum(int a, int b, int expected) {
        assertEquals(expected, calculator.multiply(a, b));
    }

    @ParameterizedTest(name="{0} / {1} = {2}")
    @DisplayName("Test Divide from CSV source")
    @CsvSource({
            "2,1,2",
            "0,5,0",
            "10,2,5",
            "5,5,1",
    })
    void divide_variousInputs_returnsCorrectSum(int a, int b, int expected) {
        assertEquals(expected, calculator.divide(a, b));
    }

    @ParameterizedTest(name="{0} ^ {1} = {2}")
    @DisplayName("Test Power from Method Source")
    @MethodSource("providePowerTestCases")
    void power_variousCases_returnsCorrectPower(int a, int b, int expected) {
        assertEquals(expected, calculator.power(a, b));
    }

    static Stream<Arguments> providePowerTestCases() {
        return Stream.of(
                Arguments.of(2, 3, 8),
                Arguments.of(5, 2, 25),
                Arguments.of(0, 2, 0),
                Arguments.of(2, 0, 1)
        );
    }
}

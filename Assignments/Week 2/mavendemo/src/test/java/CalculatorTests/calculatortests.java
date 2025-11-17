package CalculatorTests;
import Calculator.calculator;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class calculatortests {


    @Test
    public void testAdd(){
        calculator calculator = new calculator();
        assertEquals(5, calculator.add(2, 3));
    }
}



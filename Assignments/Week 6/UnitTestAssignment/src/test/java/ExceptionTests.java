import com.revature.exceptions.UserValidation;
import com.revature.exceptions.ValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExceptionTests {

    UserValidation validator;

    @BeforeEach
    public void initUserValidation(){
        validator = new UserValidation();
    }

    @Test
    void method_invalidInputNull_hasCorrectMessage() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validateEmail(null)
        );
        assertTrue(ex.getMessage().contains("cannot be null"));
    }

    @Test
    void method_invalidInputEmpty_hasCorrectMessage() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validateEmail("")
        );
        assertTrue(ex.getMessage().contains("cannot be empty"));
    }

    @Test
    void method_invalidInputNoAtSign_hasCorrectMessage() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validateEmail("testemail")
        );
        assertTrue(ex.getMessage().contains("must contain @"));
    }

    @Test
    void method_invalidInputFormat_hasCorrectMessage() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validateEmail("test@")
        );
        assertTrue(ex.getMessage().contains("invalid format"));
    }

    @Test
    void method_invalidPasswordNull_hasCorrectMessage(){
        ValidationException ex = assertThrows(
                ValidationException.class,
                () -> validator.validatePassword(null)
        );

        assertTrue(ex.getMessage().contains("Password cannot be null"));
    }

    @Test
    void method_invalidPasswordShort_hasCorrectMessage(){
        ValidationException ex = assertThrows(
                ValidationException.class,
                () -> validator.validatePassword("test")
        );

        assertTrue(ex.getMessage().contains("Password must be at least 8 characters"));
    }

    @Test
    void method_invalidPasswordUpperCase_hasCorrectMessage(){
        ValidationException ex = assertThrows(
                ValidationException.class,
                () -> validator.validatePassword("testpassword")
        );

        assertTrue(ex.getMessage().contains("Password must contain an uppercase letter"));
    }

    @Test
    void method_invalidPasswordLowerCase_hasCorrectMessage(){
        ValidationException ex = assertThrows(
                ValidationException.class,
                () -> validator.validatePassword("TESTPASSWORD")
        );

        assertTrue(ex.getMessage().contains("Password must contain a lowercase letter"));
    }

    @Test
    void method_invalidAgeNegative_hasCorrectMessage(){
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validateAge(-1)
        );

        assertTrue(ex.getMessage().contains("Age cannot be negative"));
    }

    @Test
    void method_validAgeUpperBound(){
        assertDoesNotThrow(() -> validator.validateAge(150));
    }

    @Test
    void method_validAgeLowerBound(){
        assertDoesNotThrow(() -> validator.validateAge(0));
    }

    @Test
    void validateFunctions_multipleInvalidInputs_allThrowExceptions() {
        assertAll("Email validation exceptions",
                () -> assertThrows(IllegalArgumentException.class,
                        () -> validator.validateEmail(null)),
                () -> assertThrows(ValidationException.class,
                        () -> validator.validatePassword("test")),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> validator.validateAge(200))
        );
    }


}

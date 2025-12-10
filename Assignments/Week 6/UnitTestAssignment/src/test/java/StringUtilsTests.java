import com.revature.utils.StringUtils;
import com.revature.utils.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTests {

    @Test
    public void testReverse(){
        //Arrange
        String test1 = "hello";
        String test2 = "a";
        String test3 = "";

        //Act
        test1 = StringUtils.reverse(test1);
        test2 = StringUtils.reverse(test2);
        test3 = StringUtils.reverse(test3);

        //Assert
        assertEquals("olleh", test1);
        assertEquals("a", test2);
        assertEquals("", test3);
    }

    @Test
    public void testIsEmpty_positive(){
        //Arrange
        String test = null;
        boolean isEmpty;

        //Act
        isEmpty = StringUtils.isEmpty(test);

        //Assert
        assertTrue(isEmpty);
    }

    @Test
    public void testIsEmpty_negative(){
        //Arrange
        String test = "This list is not empty";
        boolean isEmpty;

        //Act
        isEmpty = StringUtils.isEmpty(test);

        //Assert
        assertFalse(isEmpty);
    }

    @Test
    public void testFindFirst_notNull(){
        //Arrange
        String[] test = {"Find", "First", "Test"};
        String prefix = "First";
        String result;

        //Act
        result = StringUtils.findFirst(test, prefix);

        //Assert
        assertNotNull(result);
    }

    @Test
    public void testFindFirst_Null(){
        //Arrange
        String[] test = {"Find", "First", "Test"};
        String prefix = "Second";
        String result;

        //Act
        result = StringUtils.findFirst(test, prefix);

        //Assert
        assertNull(result);
    }

    @Test
    public void testSplit(){
        //Arrange
        String test = "This,string,will,be,split";
        String[] expectedResult = {"This", "string", "will", "be", "split"};

        //Act
        String[] result = StringUtils.split(test, ",");

        //Assert
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void user_allPropertiesValid() {
        User user = StringUtils.parseUser("John,Doe,30,john@test.com");

        assertAll("User properties",
                () -> assertEquals("John", user.getFirstName()),
                () -> assertEquals("Doe", user.getLastName()),
                () -> assertEquals(30, user.getAge()),
                () -> assertNotNull(user.getEmail()),
                () -> assertTrue(user.getEmail().contains("@"))
        );
    }




}

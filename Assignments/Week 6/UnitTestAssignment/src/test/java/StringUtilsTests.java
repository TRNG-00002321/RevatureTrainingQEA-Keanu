import com.revature.utils.StringUtils;
import com.revature.utils.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTests {

    @Test
    public void testReverse(){
        //Arrange
        String test = "Cat";

        //Act
        test = StringUtils.reverse(test);

        //Assert
        assertEquals("taC", test);
    }

    @Test
    public void testIsEmpty(){
        //Arrange
        String test = null;
        boolean isEmpty;

        //Act
        isEmpty = StringUtils.isEmpty(test);

        //Assert
        assertTrue(isEmpty);
    }

    @Test
    public void testFindFirst(){
        //Arrange
        String[] test = {"Find", "First", "Test"};
        String prefix = "First";
        String result;

        //Act
        result = StringUtils.findFirst(test, prefix);

        //Assert
        assertEquals(prefix, result);
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
    public void testValidateUser(){
        //Arrange
        String csv = "Keanu,Cendejas,5,password";
        User user;

        //Act
        user = StringUtils.parseUser(csv);

        //Assert
        assertNotNull(user);
    }




}

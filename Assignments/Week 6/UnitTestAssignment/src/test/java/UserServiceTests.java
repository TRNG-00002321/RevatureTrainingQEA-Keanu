import com.revature.first_mock.EmailClient;
import com.revature.first_mock.User;
import com.revature.first_mock.UserRepository;
import com.revature.first_mock.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {
    @Mock
    private UserRepository repository;  // Mock the dependency

    @Mock
    private EmailClient emailClient;  // Mock the dependency

    @InjectMocks
    private UserService userService; //Inject mocks automatically

    @Test
    @DisplayName("Test Get User That Exists")
    void getUser_existingUser_returnsUser() {
        // Arrange: Configure the mock
        User expectedUser = new User("John", "john@test.com");
        expectedUser.setId(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(expectedUser));

        // Act: Call the method under test
        User actualUser = null;
        try {
            actualUser = userService.getUser(1L).get();
        } catch (UserService.UserNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Assert: Verify the result
        assertEquals(expectedUser, actualUser);
        assertEquals("John", actualUser.getName());
    }

    @Test
    @DisplayName("Test Get User That Doesn't Exist")
    void getUser_nonExistentUser_throwsException() {
        // Arrange: Mock returns empty Optional
        when(repository.findById(999L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(UserService.UserNotFoundException.class, () -> {
            userService.getUser(999L);
        });
    }

    @Test
    @DisplayName("Test Create User Successful")
    void createUser_successful_returnsUser(){
        //Mock
        when(repository.existsByEmail("John@test.com")).thenReturn(false);
        User expectedresult = new User(1L, "John", "John@test.com");
        User result;

        when(repository.save(expectedresult))
                .thenReturn(expectedresult);

        //Act
        try {
            result = userService.createUser("John", "John@test.com");
        } catch (UserService.DuplicateUserException e) {
            throw new RuntimeException(e);
        }

        //Assert
        assertEquals(expectedresult, result);
    }

    @Test
    @DisplayName("Test Create User Duplicate User Exception")
    void createUser_fail_returnsException(){
        //Mock
        when(repository.existsByEmail("John@test.com")).thenReturn(true);

        assertThrows(UserService.DuplicateUserException.class,
                ()->{userService.createUser("John", "John@test.com");
        });
    }

    @Test
    @DisplayName("Test Invalid Name User Creation")
    void createUser_invalidName_returnsIllegalArgumentException(){

        assertThrows(IllegalArgumentException.class,
                ()->{userService.createUser(null, "John@test");
                });
    }

    @Test
    @DisplayName("Test Invalid Email User Creation")
    void createUser_invalidEmail_returnsIllegalArgumentException(){

        assertThrows(IllegalArgumentException.class,
                ()->{userService.createUser("John", "John@");
                });
    }

    @Test
    @DisplayName("Test Get Active Users")
    void getActiveUser_successful_returnsListOfUsers(){
        User user1 = new User("John", "john@test.com");
        User user2 = new User("Bob", "bob@test.com");
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);

        when(repository.findAllActive()).thenReturn(users);

        assertEquals(users, userService.getActiveUsers());
    }

    @Test
    @DisplayName("Test Get Users Count")
    void getUserCount_successful_returnsCount(){

        long expected = 3L;

        when(repository.count()).thenReturn(3L);

        assertEquals(expected, userService.getUserCount());
    }
}

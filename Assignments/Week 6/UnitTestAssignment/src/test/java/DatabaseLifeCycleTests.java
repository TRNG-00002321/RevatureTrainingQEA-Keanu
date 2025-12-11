import com.revature.test_lifecycle.MockDatabase;
import com.revature.test_lifecycle.User;
import com.revature.test_lifecycle.UserRepository;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DatabaseLifeCycleTests {
    private static MockDatabase database;
    private UserRepository repository;

    @BeforeAll
    static void setUpDatabase() {
        // This runs ONCE before all tests
        System.out.println("1. @BeforeAll: Setting up database");
        database = new MockDatabase();
        database.connect();
    }

    @AfterAll
    static void tearDownDatabase() {
        // This runs ONCE after all tests
        System.out.println("@AfterAll: Closing database");
        database.disconnect();
    }

    @Test
    @DisplayName("Test 1: Add user and verify")
    void test_addUser(){
        // Add a user
        repository.save(new User(2, "John", "john@test.com"));

        // Verify it exists
        assertEquals(2, repository.count());  // Admin + John

        System.out.println("3. @Test: Running test");
    }

    @Test
    @DisplayName("Test 2: Test isolation")
    void test_freshState(){
        User user = repository.findById(2);

        //User should be null
        assertNull(user);
        System.out.println("3. @Test: Running test");
    }

    @Test
    @DisplayName("Test 3: Database operations work independently")
    void test_independentOperations() {
        repository.save(new User(3, "Jane", "jane@test.com"));
        repository.save(new User(4, "Bob", "bob@test.com"));

        // Should have Admin + 2 new users
        assertEquals(3, repository.count());
        System.out.println("3. @Test: Running test");
    }

    @BeforeEach
    void setUpTest() {
        // TODO: Clear all data from database
        // TODO: Create a new repository instance
        // TODO: Insert any test fixtures needed
        database.clearAll();
        repository = new UserRepository(database);

        System.out.println("2. @BeforeEach: Preparing test");

        // Optional: Insert baseline test data
        database.insert(new User(1, "Admin", "admin@test.com"));
    }

    @AfterEach
    void tearDownTest() {
        // TODO: Any per-test cleanup
        // Note: The database is cleared in setUpTest anyway
        System.out.println("4. @AfterEach: Cleaning up test");
    }
}

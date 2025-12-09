package com.revature.users;

import com.revature.users.dao.UserRepository;
import com.revature.users.model.User;
import com.revature.users.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock // creates the mocked UserRepository
    private UserRepository repository;

    @InjectMocks // injects the mocked UserRepository into UserService
    private UserService service;

    private User existingUser;
    private User newUser;

    @BeforeEach
    public void setUp(){
        existingUser = new User(1L,"Keanu", "keanu@email.com");
        newUser = new User(null, "Sunni", "sunni@email.com");
    }

    @Test
    public void testUserById_positive(){
        //Arrange
        when(repository.findById(1L)).thenReturn(existingUser);

        //Act
        User foundUser = service.getUserById(1L);

        //Assert
        assertEquals("Keanu", foundUser.getName());
        verify(repository,times(1)).findById(1L);
    }

    @Test
    public void testUserById_negative(){
        //Arrange
        when(repository.findById(null)).thenReturn(null);

        //Act
        User foundUser = service.getUserById(null);

        //Assert
        assertNull(foundUser);
        verify(repository,times(1)).findById(null);
    }

    @Test
    public void testRegistration_positive(){
        //Arrange
        when(repository.findByEmail("sunni@email.com")).thenReturn(null);

        //Act
        boolean userRegistered = service.register(newUser);

        //Assert
        assertTrue(userRegistered);
        verify(repository,times(1)).findByEmail("sunni@email.com");
    }

    @Test
    public void testRegistration_userExists(){
        //Arrange
        when(repository.findByEmail("keanu@email.com")).thenReturn(existingUser);

        //Act
        boolean userRegistered = service.register(existingUser);

        //Assert
        assertFalse(userRegistered);
        verify(repository,times(1)).findByEmail("keanu@email.com");
    }
}

//write the negative test case where user is not found
//test the successful registration
//test the registration when user already exists

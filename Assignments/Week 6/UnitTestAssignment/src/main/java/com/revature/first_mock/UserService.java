package com.revature.first_mock;

import java.util.List;
import java.util.Optional;

public class UserService {
    UserRepository userRepository;
    EmailClient emailClient;

    public class UserNotFoundException extends Exception{
        public UserNotFoundException(String message) {
            super(message);
        }
    }

    public class DuplicateUserException extends Exception{
        public DuplicateUserException(String message) {
            super(message);
        }
    }

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserService(EmailClient emailClient) {
        this.emailClient = emailClient;
    }

    public UserService(UserRepository userRepository, EmailClient emailClient) {
        this.userRepository = userRepository;
        this.emailClient = emailClient;
    }

    public Optional<User> getUser(long l) throws UserNotFoundException {
        if(userRepository.findById(l).isPresent()){
            return userRepository.findById(l);
        }
        else{
            throw new UserNotFoundException("User not found");
        }
    }

    public User createUser(String name, String email) throws DuplicateUserException {

        if(name == null)
        {
            throw new IllegalArgumentException();
        }
        else if(email.startsWith("@") || email.endsWith("@"))
        {
            throw new IllegalArgumentException();
        }
        else if(userRepository.existsByEmail(email)){
            throw new DuplicateUserException("Duplicate User");
        }
        else{
            return userRepository.save(new User(1L, name, email));
        }
    }

    public List<User> getActiveUsers(){
        return userRepository.findAllActive();
    }

    public long getUserCount(){
        return userRepository.count();
    }
}

package com.revature.first_mock;

import java.util.List;
import java.util.Optional;

// UserRepository.java - Interface to mock
public interface UserRepository {
    Optional<User> findById(Long id);
    User save(User user);
    void deleteById(Long id);
    List<User> findAllActive();
    boolean existsByEmail(String email);
    long count();
}


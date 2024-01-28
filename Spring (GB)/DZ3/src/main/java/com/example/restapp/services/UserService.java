package com.example.restapp.services;

import com.example.restapp.domain.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    /**
     * Create new user
     *
     * @param name  User name
     * @param age   User age
     * @param email User email address
     * @return New user
     */
    public User createUser(String name, int age, String email) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);
        return user;
    }
}

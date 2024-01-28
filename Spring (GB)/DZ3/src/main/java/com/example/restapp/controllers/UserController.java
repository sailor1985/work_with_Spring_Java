package com.example.restapp.controllers;

import com.example.restapp.domain.User;
import com.example.restapp.services.RegistrationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")//localhost:8080/user
public class UserController {
    private RegistrationService registrationService;

    //Constructor
    public UserController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    /**
     * GET: Request a list of users from repository
     *
     * @return A list of users
     */
    @GetMapping
    public List<User> userList() {
        return (List<User>) registrationService
                .getDataProcessingService()
                .getRepositoryH2()
                .findAll();
    }

    /**
     * POST: Request for adding user to repository
     *
     * @param user New user
     * @return Line about executing a POST request
     */
    @PostMapping("/body")//localhost:8080/user/body
    public String userAddFromBody(@RequestBody User user) {
        registrationService
                .getDataProcessingService()
                .getRepositoryH2()
                .save(user);
        return "User added from body!";
    }

    /**
     * New user registration
     *
     * @param user New user
     */
    @PostMapping("/registration")////localhost:8080/user/registration
    public String userRegistration(@RequestBody User user) {
        registrationService.processRegistration(
                user.getName(),
                user.getAge(),
                user.getEmail()
        );
        return "Registered a new user: " + user.getName();
    }

    /**
     * New user from parameters
     *
     * @param user HTTP request body
     * @return New user
     */
    @PostMapping("/param")
    public User userAddFromParam(@RequestBody User user) {
        User userParam = registrationService.getUserService()
                .createUser(user.getName(), user.getAge(), user.getEmail());
        registrationService.getNotificationService()
                .sendNotification("INFO >> Created new user from parameters!");
        return userParam;
    }
}

package com.example.restapp.services;

import com.example.restapp.domain.User;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final DataProcessingService dataProcessingService;
    private final UserService userService;
    private final NotificationService notificationService;

    public RegistrationService(
            DataProcessingService dataProcessingService,
            UserService userService,
            NotificationService notificationService) {
        this.dataProcessingService = dataProcessingService;
        this.userService = userService;
        this.notificationService = notificationService;
    }

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    public UserService getUserService() {
        return userService;
    }

    public NotificationService getNotificationService() {
        return notificationService;
    }

    /**
     * New User Registration
     *
     * @param name  Username
     * @param age   User age
     * @param email User email address
     */
    public void processRegistration(String name, int age, String email) {
        User user = userService.createUser(name, age, email);
        notificationService.notifyUser(user);
        dataProcessingService.addUserToRepo(user);
        notificationService.sendNotification("INFO >> User " + user.getName() + " added to the repository!");
    }
}

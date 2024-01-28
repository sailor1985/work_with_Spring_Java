package com.example.restapp.services;

import com.example.restapp.domain.User;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void notifyUser(User user) {
        System.out.println("INFO >>> A new user has been created: " + user.getName() + ".");
    }

    public void sendNotification(String s) {
        System.out.println(s);
    }
}

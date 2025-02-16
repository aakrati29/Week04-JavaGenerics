package com.example.day06reflection.dependencyinjection;

public class ServiceForUsers {

    @Inject
    EmailService emailService;

    public void notifyUser() {
        emailService.sendEmail("Hello, user! Your account has been updated.");
    }
}


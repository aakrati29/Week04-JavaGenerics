package com.example.day06reflection.dependencyinjection;

public class Main {
    public static void main(String[] args) {
        try {
            InjectContainer diContainer = new InjectContainer();

            diContainer.register(EmailService.class);

            ServiceForUsers userService = new ServiceForUsers();

            diContainer.injectDependencies(userService);

            userService.notifyUser();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


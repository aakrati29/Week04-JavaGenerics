package com.example.day06annotations.careatemaxlengthannotationforfieldvalidation;

public class Main {
    public static void main(String[] args) {
        try {
            Users validUser = new Users("Aakrati");
            System.out.println("Valid user created: " + validUser.getUsername());

            Users invalidUser = new Users("ThisUsernameIsTooLong");
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}


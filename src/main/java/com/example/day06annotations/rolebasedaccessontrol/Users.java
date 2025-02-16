package com.example.day06annotations.rolebasedaccessontrol;

public class Users {
    private String username;
    private String role;

    public Users(String username, String role) {
        this.username = username;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public String getUsername() {
        return username;
    }
}

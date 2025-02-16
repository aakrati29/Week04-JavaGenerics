package com.example.day06annotations.serializationannotationjsonfield;

public class Users {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_email")
    private String email;

    private int age;

    public Users(String username, String email, int age) {
        this.username = username;
        this.email = email;
        this.age = age;
    }

    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public int getAge() { return age; }
}


package com.codecool.stackoverflowtw.users.model;

public class User {
    private int counter;
    private final int id;
    private String username;
    private String password;
    private final String email;

    public User(String username, String password, String email) {
        this.id = ++counter;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}

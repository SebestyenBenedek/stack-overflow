package com.codecool.stackoverflowtw.users.model;

import java.util.Random;
import java.util.UUID;

public class User {
    private final UUID id;
    private String username;
    private String password;
    private final String email;

    public User(String username, String password, String email) {
        this.id = UUID.randomUUID();
        this.username = username;
        this.password = password;
        this.email = email;
    }
}

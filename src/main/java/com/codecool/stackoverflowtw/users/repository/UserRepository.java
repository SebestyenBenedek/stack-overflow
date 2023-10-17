package com.codecool.stackoverflowtw.users.repository;

import com.codecool.stackoverflowtw.users.model.User;

import java.util.Set;
import java.util.UUID;

public interface UserRepository {
    Set<User> getAll();
    User get();
    void delete(UUID id);
    void add(String username, String password, String email);
    void update(UUID id, String username, String password, String email);
}

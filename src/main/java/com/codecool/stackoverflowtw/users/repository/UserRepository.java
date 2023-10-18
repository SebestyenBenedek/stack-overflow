package com.codecool.stackoverflowtw.users.repository;

import com.codecool.stackoverflowtw.users.model.User;

import java.util.Set;

public interface UserRepository {
    Set<User> getAll();
    User get(int id);
    void delete(int id);
    void add(String username, String password, String email);
    void update(int id, String username, String password, String email);

    User findByUsername(String name);
}

package com.codecool.stackoverflowtw.users.repository;

import com.codecool.stackoverflowtw.database.service.ConnectDatabaseImpl;
import com.codecool.stackoverflowtw.logger.Logger;
import com.codecool.stackoverflowtw.users.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Set;
import java.util.UUID;

public class UserRepositoryImpl implements UserRepository {
    private final String dbFile;
    private final Logger logger;
    private ConnectDatabaseImpl connectDatabase;

    public UserRepositoryImpl(String dbFile, Logger logger) {
        this.dbFile = dbFile;
        this.logger = logger;
    }

    private Connection getConnection() {
        return connectDatabase.getConnection(dbFile, logger);
    }


    @Override
    public Set<User> getAll() {
        return null;
    }

    @Override
    public User get() {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public void add(String username, String password, String email) {

    }

    @Override
    public void update(UUID id, String username, String password, String email) {

    }
}

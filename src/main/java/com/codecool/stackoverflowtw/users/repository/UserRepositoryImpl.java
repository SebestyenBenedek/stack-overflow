package com.codecool.stackoverflowtw.users.repository;

import com.codecool.stackoverflowtw.database.service.ConnectDatabaseImpl;
import com.codecool.stackoverflowtw.logger.Logger;
import com.codecool.stackoverflowtw.users.model.User;

import java.sql.*;
import java.util.HashSet;
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
        Set<User> users = new HashSet<>();
        String query = "SELECT * FROM users";

        try (Connection conn = getConnection()) {
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        UUID id = resultSet.getObject("id", java.util.UUID.class);
                        String username = resultSet.getString("username");
                        String password = resultSet.getString("password");
                        String email = resultSet.getString("email");
                        users.add(new User(username, password, email));

                        logger.logInfo("Retrieving all the Users was successfully!");
                    }
                    resultSet.close();
                    preparedStatement.close();
                    conn.close();
                }
            } catch (SQLException e) {
                logger.logError("Error retrieving all the Users " + e.getMessage());
            }

        return users;
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

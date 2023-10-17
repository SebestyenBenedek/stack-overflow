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
    public User get(UUID id) {
        String query = "SELECT * FROM users WHERE id = ?";

        try (Connection conn = getConnection()) {
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setObject(1, java.util.UUID.class);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    String username = resultSet.getString("username");
                    String password = resultSet.getString("password");
                    String email = resultSet.getString("email");

                    logger.logInfo("Retrieving Uer was successfully!");

                    return new User(username, password, email);
                }
                resultSet.close();
                preparedStatement.close();
                conn.close();
            }
        } catch (SQLException e) {
            logger.logError("Error retrieving question: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void delete(UUID id) {
        String query = "DELETE FROM users WHERE id = ?";

        try (Connection conn = getConnection()) {
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setObject(1, java.util.UUID.class);
                preparedStatement.executeUpdate();

                logger.logInfo("Question deleted successfully!");
                preparedStatement.close();
                conn.close();
            }
        } catch (SQLException e) {
            logger.logError("Error deleting question: " + e.getMessage());
        }
    }

    @Override
    public void add(String username, String password, String email) {
        String query = "INSERT INTO users(username, password, email) VALUES(?,?,?)";

        try (Connection conn = getConnection()) {
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setString(2, username);
                preparedStatement.setString(3, password);
                preparedStatement.setString(4, email);

                logger.logInfo("Adding a new User was successfully!");
                preparedStatement.close();
                conn.close();
            }
        } catch (SQLException e) {
            logger.logError("Error adding new User: " + e.getMessage());
        }
    }

    @Override
    public void update(UUID id, String username, String password, String email) {
        String query = "UPDATE users SET username = ?, password = ?, email = ? WHERE id = ?";

        try (Connection conn = getConnection()) {
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setString(2, username);
                preparedStatement.setString(3, password);
                preparedStatement.setString(4, email);

                logger.logInfo("Updating User was successfully!");
                preparedStatement.close();
                conn.close();
            }
        } catch (SQLException e) {
            logger.logError("Error updating User: " + e.getMessage());
        }
    }
}

package com.codecool.stackoverflowtw.answers.repository;

import com.codecool.stackoverflowtw.answers.model.Answer;
import com.codecool.stackoverflowtw.database.service.ConnectDatabaseImpl;
import com.codecool.stackoverflowtw.logger.Logger;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class AnswerRepositoryImpl implements AnswerRepository {
    private final String connectionString;
    private final Logger logger;
    private ConnectDatabaseImpl connectDatabase;

    public AnswerRepositoryImpl(String connectionString, Logger logger, ConnectDatabaseImpl connectDatabase) {
        this.connectionString = connectionString;
        this.logger = logger;
        this.connectDatabase = connectDatabase;
    }

    private Connection getConnection() {
        return connectDatabase.getConnection(connectionString, logger);
    }

    @Override
    public Set<Answer> getAll(int questionId) {
        Set<Answer> answerList = new HashSet<>();
        String query = "SELECT * FROM answers WHERE questionId = ?";

        try (Connection conn = getConnection()) {
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setInt(1, questionId);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String description = resultSet.getString("description");
                    int question = resultSet.getInt("questionId");
                    LocalDateTime createdAt = resultSet.getTimestamp("createdAt").toLocalDateTime();
                    int numberOfLikes = resultSet.getInt("numberOfLikes");
                    int numberOfDislikes = resultSet.getInt("numberOfDislikes");
                    int user = resultSet.getInt("userId");

                    answerList.add(new Answer(id, description, question, createdAt, numberOfLikes, numberOfDislikes, user));

                    logger.logInfo("Retrieving all the answers for the chosen question!");
                }
                resultSet.close();
                preparedStatement.close();
                conn.close();
            }
        } catch (SQLException e) {
            logger.logError("Error retrieving all the answers for the chosen question!" + e.getMessage());
        }

        return answerList;
    }

    @Override
    public Answer get(int answerId) {
        String query = "SELECT * FROM answers WHERE id = ?";

        try (Connection conn = getConnection()) {
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setInt(1, answerId);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String description = resultSet.getString("description");
                    int question = resultSet.getInt("questionId");
                    LocalDateTime createdAt = resultSet.getTimestamp("createdAt").toLocalDateTime();
                    int numberOfLikes = resultSet.getInt("numberOfLikes");
                    int numberOfDislikes = resultSet.getInt("numberOfDislikes");
                    int user = resultSet.getInt("userId");

                    logger.logInfo("Retrieving answer was successfully!");

                    return new Answer(id, description, question, createdAt, numberOfLikes, numberOfDislikes, user);
                }
                resultSet.close();
                preparedStatement.close();
                conn.close();
            }
        } catch (SQLException e) {
            logger.logError("Error retrieving answer: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM answers WHERE id = ?";

        try (Connection conn = getConnection()) {
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();

                logger.logInfo("Answer deleted successfully!");
                preparedStatement.close();
                conn.close();
            }
        } catch (SQLException e) {
            logger.logError("Error deleting answer: " + e.getMessage());
        }
    }

    @Override
    public void add(String description, int questionId, LocalDateTime createdAt, int numberOfLikes, int numberOfDislikes, int userId) {
        String query = "INSERT INTO answers(description, questionId, createdAt, numberOfLikes, numberOdDislikes, userId) VALUES(?,?,?,?,?,?)";

        try (Connection conn = getConnection()) {
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setString(1, description);
                preparedStatement.setInt(2, questionId);
                preparedStatement.setTimestamp(3, Timestamp.valueOf(createdAt));
                preparedStatement.setInt(4, numberOfLikes);
                preparedStatement.setInt(5, numberOfDislikes);
                preparedStatement.setInt(6, userId);

                logger.logInfo("Adding a new answer to the chosen question was successfully!");
                preparedStatement.close();
                conn.close();
            }
        } catch (SQLException e) {
            logger.logError("Error adding new answer: " + e.getMessage());
        }
    }

    @Override
    public void update(int id, String description) {
        String query = "UPDATE anwers SET description = ? WHERE id = ?";

        try (Connection conn = getConnection()) {
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setString(1, description);
                preparedStatement.setInt(2, id);

                logger.logInfo("Updating answer was successfully!");
                preparedStatement.close();
                conn.close();
            }
        } catch (SQLException e) {
            logger.logError("Error updating answer: " + e.getMessage());
        }
    }
}

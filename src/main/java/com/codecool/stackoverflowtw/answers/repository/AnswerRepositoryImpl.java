package com.codecool.stackoverflowtw.answers.repository;

import com.codecool.stackoverflowtw.answers.model.Answer;
import com.codecool.stackoverflowtw.database.service.ConnectDatabaseImpl;
import com.codecool.stackoverflowtw.logger.Logger;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class AnswerRepositoryImpl implements AnswerRepository {
    private final String dbFile;
    private final Logger logger;
    private ConnectDatabaseImpl connectDatabase;

    public AnswerRepositoryImpl(String dbFile, Logger logger) {
        this.dbFile = dbFile;
        this.logger = logger;
    }

    private Connection getConnection() {
        return connectDatabase.getConnection(dbFile, logger);
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
                    String description = resultSet.getString("description");
                    int question = resultSet.getInt("questionId");
                    answerList.add(new Answer(description, question));

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
    public Answer get(int id) {
        String query = "SELECT * FROM answers WHERE id = ?";

        try (Connection conn = getConnection()) {
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    String description = resultSet.getString("description");
                    int question = resultSet.getInt("questionId");

                    logger.logInfo("Retrieving answer was successfully!");

                    return new Answer(description, question);
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
    public void add(String description, int questionId) {
        String query = "INSERT INTO answers(description, questionId) VALUES(?,?)";

        try (Connection conn = getConnection()) {
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setString(1, description);
                preparedStatement.setInt(2, questionId);

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

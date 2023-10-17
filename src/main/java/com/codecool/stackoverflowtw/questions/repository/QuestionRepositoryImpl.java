package com.codecool.stackoverflowtw.questions.repository;

import com.codecool.stackoverflowtw.database.service.ConnectDatabaseImpl;
import com.codecool.stackoverflowtw.logger.Logger;
import com.codecool.stackoverflowtw.questions.model.Question;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class QuestionRepositoryImpl implements QuestionRepository {
    private final String dbFile;
    private final Logger logger;
    private ConnectDatabaseImpl connectDatabase;

    public QuestionRepositoryImpl(String dbFile, Logger logger) {
        this.dbFile = dbFile;
        this.logger = logger;
    }

    private Connection getConnection() {
        return connectDatabase.getConnection(dbFile, logger);
    }

    @Override
    public List<Question> getAll() {
        List<Question> questionList = new ArrayList<>();
        String query = "SELECT * FROM questions";

        try (Connection conn = getConnection()) {
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String title = resultSet.getString("title");
                    String description = resultSet.getString("description");
                    questionList.add(new Question(title, description));

                    logger.logInfo("Retrieving all the questions was successfully!");
                }
                resultSet.close();
                preparedStatement.close();
                conn.close();
            }
        } catch (SQLException e) {
            logger.logError("Error retrieving all questions: " + e.getMessage());
        }

        return questionList;
    }

    @Override
    public Question get(int id) {
        String query = "SELECT * FROM questions WHERE id = ?";

        try (Connection conn = getConnection()) {
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    String title = resultSet.getString("title");
                    String description = resultSet.getString("description");

                    logger.logInfo("Retrieving question was successfully!");

                    return new Question(title, description);
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
    public void delete(int id) {
        String query = "DELETE FROM questions WHERE id = ?";

        try (Connection conn = getConnection()) {
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setInt(1, id);
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
    public void add(String title, String description) {
        String query = "INSERT INTO questions(title, description) VALUES(?,?)";

        try (Connection conn = getConnection()) {
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setString(1, title);
                preparedStatement.setString(2, description);
                preparedStatement.setObject(3, LocalDateTime.now());

                logger.logInfo("Adding a new question was successfully!");
                preparedStatement.close();
                conn.close();
            }
        } catch (SQLException e) {
            logger.logError("Error adding new question: " + e.getMessage());
        }
    }
}

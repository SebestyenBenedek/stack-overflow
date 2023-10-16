package com.codecool.stackoverflowtw.questions.repository;

import com.codecool.stackoverflowtw.questions.controller.dto.QuestionDTO;
import com.codecool.stackoverflowtw.logger.Logger;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class QuestionRepositoryImpl implements QuestionRepository {
    private final String dbFile;
    private final Logger logger;

    public QuestionRepositoryImpl(String dbFile, Logger logger) {
        this.dbFile = dbFile;
        this.logger = logger;
    }

    private Connection getConnection() {
        Connection conn = null;

        try {
            String url = "jdbc:sqlite:" + dbFile;
            conn = DriverManager.getConnection(url);

            logger.logInfo("Connection to SQLite has been established.");
        } catch (SQLException e) {
            logger.logError("Error while connecting to SQLite: " + e.getMessage());
        }

        return conn;
    }

    @Override
    public List<QuestionDTO> getAll() {
        List<QuestionDTO> questionList = new ArrayList<>();
        String query = "SELECT * FROM questions";

        try (Connection conn = getConnection()) {
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String title = resultSet.getString("title");
                    String description = resultSet.getString("description");
                    java.sql.Date sqlDate = Date.valueOf(resultSet.getDate("created").toString().split("T")[0]);
                    java.sql.Time sqlTime = Time.valueOf(resultSet.getTime("created").toString().split("T")[1]);
                    LocalDateTime created = LocalDateTime.parse(sqlDate + "T" + sqlTime);
                    questionList.add(new QuestionDTO(id, title, description, created));

                    logger.logInfo("Retrieving all the questions was successfully!");
                }
            }
        } catch (SQLException e) {
            logger.logError("Error retrieving all questions: " + e.getMessage());
        }

        return questionList;
    }

    @Override
    public QuestionDTO get(int id) {
        String query = "SELECT * FROM questions WHERE id = ?";

        try (Connection conn = getConnection()) {
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    String title = resultSet.getString("title");
                    String description = resultSet.getString("description");
                    java.sql.Date sqlDate = Date.valueOf(resultSet.getDate("created").toString().split("T")[0]);
                    java.sql.Time sqlTime = Time.valueOf(resultSet.getTime("created").toString().split("T")[1]);
                    LocalDateTime created = LocalDateTime.parse(sqlDate + "T" + sqlTime);

                    logger.logInfo("Retrieving question was successfully!");

                    return new QuestionDTO(id, title, description, created);
                }
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
            }
        } catch (SQLException e) {
            logger.logError("Error adding new question: " + e.getMessage());
        }
    }
}

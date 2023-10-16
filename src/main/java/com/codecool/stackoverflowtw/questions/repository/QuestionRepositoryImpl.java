package com.codecool.stackoverflowtw.questions.repository;

import com.codecool.stackoverflowtw.questions.controller.dto.QuestionDTO;
import com.codecool.stackoverflowtw.logger.Logger;

import java.sql.*;
import java.time.LocalDateTime;
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
                    questionList.add(new QuestionDTO(id, title, description, LocalDateTime.now()));
                }
            }
        } catch (SQLException e) {
            logger.logError("Error retrieving all questions: " + e.getMessage());
        }

        return questionList;
    }

    @Override
    public void get() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void add() {

    }
}

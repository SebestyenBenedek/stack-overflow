package com.codecool.stackoverflowtw.answers.repository;

import com.codecool.stackoverflowtw.answers.model.Answer;
import com.codecool.stackoverflowtw.database.service.ConnectDatabaseImpl;
import com.codecool.stackoverflowtw.logger.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public List<Answer> getAll(int questionId) {
        List<Answer> answerList = new ArrayList<>();
        String query = "SELECT * FROM answers WHERE question = questionId";

        try (Connection conn = getConnection()) {
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String description = resultSet.getString("description");
                    answerList.add(new Answer(description));

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
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void add(String description) {

    }

    @Override
    public void update(int id) {

    }
}

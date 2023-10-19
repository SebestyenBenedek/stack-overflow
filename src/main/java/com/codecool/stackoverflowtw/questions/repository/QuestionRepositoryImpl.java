package com.codecool.stackoverflowtw.questions.repository;

import com.codecool.stackoverflowtw.database.service.ConnectDatabase;
import com.codecool.stackoverflowtw.database.service.ConnectDatabaseImpl;
import com.codecool.stackoverflowtw.logger.Logger;
import com.codecool.stackoverflowtw.questions.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class QuestionRepositoryImpl implements QuestionRepository {
    private final Logger logger;
    private final ConnectDatabase connectDatabase;

    @Autowired
    public QuestionRepositoryImpl(Logger logger, ConnectDatabase connectDatabase) {
        this.logger = logger;
        this.connectDatabase = connectDatabase;
    }

    private Connection getConnection() {
        return connectDatabase.getConnection();
    }

    @Override
    public List<Question> getAll() {
        List<Question> questionList = new ArrayList<>();
        String query = "SELECT * FROM questions";

        try (Connection conn = getConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                LocalDateTime createdAt = resultSet.getTimestamp("createdAt").toLocalDateTime();
                int numberOfAnswers = resultSet.getInt("numberOfAnwsers");
                int numberOfViews = resultSet.getInt("numberOfViews");
                int userId = resultSet.getInt("userId");

                questionList.add(new Question(id, title, description, createdAt, numberOfAnswers, numberOfViews, userId));

            }
            logger.logInfo("Retrieving all the questions was successfully!");
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            logger.logError("Error retrieving all questions: " + e.getMessage());
        }

        return questionList;
    }

    @Override
    public Question get(int questionId) {
        String query = "SELECT * FROM questions WHERE id = ?";

        try (Connection conn = getConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, questionId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                LocalDateTime createdAt = resultSet.getTimestamp("createdAt").toLocalDateTime();
                int numberOfAnswers = resultSet.getInt("numberOfAnwsers");
                int numberOfViews = resultSet.getInt("numberOfViews");
                int user = resultSet.getInt("userId");

                logger.logInfo("Retrieving question was successfully!");

                return new Question(id, title, description, createdAt, numberOfAnswers, numberOfViews, user);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            logger.logError("Error retrieving question: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM questions WHERE id = ?";

        try (Connection conn = getConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            logger.logInfo("Question deleted successfully!");

            preparedStatement.close();
        } catch (SQLException e) {
            logger.logError("Error deleting question: " + e.getMessage());
        }
    }

    @Override
    public void add(String title, String description, LocalDateTime createdAt, int numberOfLikes, int numberOfViews, int userId) {
        String query = "INSERT INTO questions(title, description, createdAt, numberofanwsers, numberOfViews, userId) VALUES(?,?,?,?,?,?)";

        try (Connection conn = getConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, description);
            preparedStatement.setTimestamp(3, Timestamp.valueOf(createdAt));
            preparedStatement.setInt(4, numberOfLikes);
            preparedStatement.setInt(5, numberOfViews);
            preparedStatement.setInt(6, userId);

            logger.logInfo("Adding a new question was successfully!");

            preparedStatement.close();
        } catch (SQLException e) {
            logger.logError("Error adding new question: " + e.getMessage());
        }
    }
}

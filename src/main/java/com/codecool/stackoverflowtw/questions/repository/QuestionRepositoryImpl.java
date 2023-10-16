package com.codecool.stackoverflowtw.questions.repository;

import com.codecool.stackoverflowtw.questions.controller.dto.QuestionDTO;
import com.codecool.stackoverflowtw.logger.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

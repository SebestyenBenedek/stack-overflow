package com.codecool.stackoverflowtw.database.service;

import com.codecool.stackoverflowtw.logger.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDatabaseImpl implements ConnectDatabase {
    private final String connectionString;
    private final Logger logger;

    public ConnectDatabaseImpl(String connectionString, Logger logger) {
        this.connectionString = connectionString;
        this.logger = logger;
    }

    public Connection getConnection() {
        Connection conn = null;

        try {
            String url = "jdbc:sqlite:" + connectionString;
            conn = DriverManager.getConnection(url);

            logger.logInfo("Connection to SQLite has been established.");
        } catch (SQLException e) {
            logger.logError("Error while connecting to SQLite: " + e.getMessage());
        }

        return conn;
    }
}

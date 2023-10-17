package com.codecool.stackoverflowtw.database.service;

import com.codecool.stackoverflowtw.logger.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabaseImpl implements ConnectDatabase {
    public Connection getConnection(String dbFile, Logger logger) {
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
}

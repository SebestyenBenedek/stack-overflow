package com.codecool.stackoverflowtw.database.service;

import com.codecool.stackoverflowtw.logger.Logger;
import org.springframework.beans.factory.annotation.Autowired;

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
            String url = "jdbc:postgresql:" + connectionString;
            conn = DriverManager.getConnection(url);

            logger.logInfo("Connection to postgresql has been established.");
        } catch (SQLException e) {
            logger.logError("Error while connecting to postgresql: " + e.getMessage());
        }

        return conn;
    }
}

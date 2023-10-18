package com.codecool.stackoverflowtw.database.service;

import com.codecool.stackoverflowtw.logger.Logger;

import java.sql.Connection;

public interface ConnectDatabase {
    public Connection getConnection();
}

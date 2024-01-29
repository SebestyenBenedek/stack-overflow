package com.codecool.stackoverflowtw;

import com.codecool.stackoverflowtw.database.service.ConnectDatabase;
import com.codecool.stackoverflowtw.database.service.ConnectDatabaseImpl;
import com.codecool.stackoverflowtw.logger.ConsoleLogger;
import com.codecool.stackoverflowtw.logger.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.sql.Connection;


@SpringBootApplication
public class StackoverflowTwApplication {

    public static void main(String[] args) {
        SpringApplication.run(StackoverflowTwApplication.class, args);
    }

    @Bean
    Logger getLogger() {
        return new ConsoleLogger();
    }

    @Bean
    ConnectDatabase getDBConnector() {
        String connectionString = "jdbc:postgresql://db:5432/stackOverflow";

        return new ConnectDatabaseImpl(connectionString, getLogger());
    }
}

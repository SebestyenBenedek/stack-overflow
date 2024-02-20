package com.codecool.stackoverflowtw;

import com.codecool.stackoverflowtw.database.service.ConnectDatabase;
import com.codecool.stackoverflowtw.database.service.ConnectDatabaseImpl;
import com.codecool.stackoverflowtw.logger.ConsoleLogger;
import com.codecool.stackoverflowtw.logger.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
        String host = System.getenv("POSTGRES_HOST");
        String port = System.getenv("POSTGRES_PORT");
        String dbName = System.getenv("POSTGRES_DB");

        String connectionString = "jdbc:postgresql://" + host + ":" + port + "/" + dbName;

        return new ConnectDatabaseImpl(connectionString, getLogger());
    }
}

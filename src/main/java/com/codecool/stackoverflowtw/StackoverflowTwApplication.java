package com.codecool.stackoverflowtw;

import com.codecool.stackoverflowtw.database.service.ConnectDatabaseImpl;
import com.codecool.stackoverflowtw.logger.ConsoleLogger;
import com.codecool.stackoverflowtw.logger.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.sql.Connection;


@SpringBootApplication
@ComponentScan({"com.codecool.stackoverflowtw.logger"})
public class StackoverflowTwApplication {

    public static void main(String[] args) {

        Logger logger = new ConsoleLogger();

        String connectionString = "src/main/resources/StackOverflow.db";
        ConnectDatabaseImpl connectDatabase = new ConnectDatabaseImpl(connectionString, logger);
        
        connectDatabase.getConnection();



        SpringApplication.run(StackoverflowTwApplication.class, args);


    }
}

package com.codecool.stackoverflowtw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan({"com.codecool.stackoverflowtw.logger"})
public class StackoverflowTwApplication {

    public static void main(String[] args) {
        SpringApplication.run(StackoverflowTwApplication.class, args);
    }
}

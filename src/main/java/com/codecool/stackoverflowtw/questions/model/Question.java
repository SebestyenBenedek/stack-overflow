package com.codecool.stackoverflowtw.questions.model;

import jdk.jfr.DataAmount;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDateTime;

public class Question {
    private int counter;

    private final int id;
    private String title;
    private String description;
    private final LocalDateTime created;

    public Question(String title, String description) {
        this.id = ++counter;
        this.title = title;
        this.description = description;
        this.created = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreated() {
        return created;
    }
}

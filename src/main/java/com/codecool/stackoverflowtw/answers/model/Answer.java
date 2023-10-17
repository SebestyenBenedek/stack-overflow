package com.codecool.stackoverflowtw.answers.model;

import java.time.LocalDateTime;

public class Answer {
    private int counter;

    private final int id;
    private String description;
    private final int questionId;
    private final LocalDateTime created;
    private int numberOfLike;
    private int numberOfDislike;

    public Answer(String description, int questionId) {
        this.id = ++counter;
        this.description = description;
        this.questionId = questionId;
        this.created = LocalDateTime.now();
        this.numberOfLike = 0;
        this.numberOfDislike = 0;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public int getQuestionId() {
        return questionId;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public int getNumberOfLike() {
        return numberOfLike;
    }

    public int getNumberOfDislike() {
        return numberOfDislike;
    }
}

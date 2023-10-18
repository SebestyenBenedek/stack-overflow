package com.codecool.stackoverflowtw.answers.model;

import java.time.LocalDateTime;

public class Answer {
    private final int id;
    private String description;
    private final int questionId;
    private final LocalDateTime createdAt;
    private int numberOfLikes;
    private int numberOfDislikes;
    private final int userId;

    public Answer(int id, String description, int questionId, LocalDateTime createdAt, int numberOfLikes, int numberOfDislikes, int userId) {
        this.id = id;
        this.description = description;
        this.questionId = questionId;
        this.createdAt = createdAt;
        this.numberOfLikes = numberOfLikes;
        this.numberOfDislikes = numberOfDislikes;
        this.userId = userId;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public int getNumberOfLike() {
        return numberOfLikes;
    }

    public int getNumberOfDislike() {
        return numberOfDislikes;
    }

    public int getNumberOfLikes() {
        return numberOfLikes;
    }

    public int getNumberOfDislikes() {
        return numberOfDislikes;
    }

    public int getUserId() {
        return userId;
    }
}

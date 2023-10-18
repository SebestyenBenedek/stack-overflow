package com.codecool.stackoverflowtw.questions.model;

import com.codecool.stackoverflowtw.users.model.User;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Question {
    private final int id;
    private String title;
    private String description;
    private final LocalDateTime createdAt;
    private int numberOfAnswers;
    private int numberOfViews;
    private final int userId;
    private final int tagId;

    public Question(int id, String title, String description, LocalDateTime createdAt, int numberOfAnswers, int numberOfViews, int userId, int tagId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.numberOfAnswers = numberOfAnswers;
        this.numberOfViews = numberOfViews;
        this.userId = userId;
        this.tagId = tagId;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public int getNumberOfAnswers() {
        return numberOfAnswers;
    }

    public int getNumberOfViews() {
        return numberOfViews;
    }

    public int getUserId() {
        return userId;
    }

    public int getTagId() {
        return tagId;
    }
}

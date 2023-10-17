package com.codecool.stackoverflowtw.questions.model;

import com.codecool.stackoverflowtw.users.model.User;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Question {
    private int counter;

    private final int id;
    private String title;
    private String description;
    private final LocalDateTime created;
    private Set<Tag> tags;
    private int numberOfAnswer;
    private int numberOfViews;

    public Question(String title, String description) {
        this.id = ++counter;
        this.title = title;
        this.description = description;
        this.created = LocalDateTime.now();
        this.tags = new HashSet<>();
        this.numberOfAnswer = 0;
        this.numberOfViews = 0;
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

    public Set<Tag> getTags() {
        return tags;
    }

    public int getNumberOfAnswer() {
        return numberOfAnswer;
    }

    public int getNumberOfViews() {
        return numberOfViews;
    }
}

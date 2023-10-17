package com.codecool.stackoverflowtw.answers.model;

import java.time.LocalDateTime;

public class Answer {
    private int counter;

    private final int id;
    private String description;
    private final LocalDateTime created;
    private int numberOfLike;
    private int numberOfDislike;

    public Answer(String description) {
        this.id = ++counter;
        this.description = description;
        this.created = LocalDateTime.now();
        this.numberOfLike = 0;
        this.numberOfDislike = 0;
    }
}

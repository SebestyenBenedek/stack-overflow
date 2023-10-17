package com.codecool.stackoverflowtw.questions.model;

import com.codecool.stackoverflowtw.questions.model.Question;

import java.util.HashSet;
import java.util.Set;

public class Tag {
    private final String name;
    private Set<Question> questions;

    public Tag(String name) {
        this.name = name;
        this.questions = new HashSet<>();
    }

    public void add(Question question) {
        questions.add(question);
    }
}

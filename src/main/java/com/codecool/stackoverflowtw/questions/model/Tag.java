package com.codecool.stackoverflowtw.questions.model;

import com.codecool.stackoverflowtw.questions.model.Question;

import java.util.HashSet;
import java.util.Set;

public class Tag {
    private final int id;
    private String name;

    public Tag(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

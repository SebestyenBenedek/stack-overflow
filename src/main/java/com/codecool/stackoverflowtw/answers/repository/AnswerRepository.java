package com.codecool.stackoverflowtw.answers.repository;

import com.codecool.stackoverflowtw.answers.model.Answer;

import java.util.List;

public interface AnswerRepository {
    List<Answer> getAll();
    Answer get(int id);
    void delete(int id);
    void add(String description);
    void update(int id);
}

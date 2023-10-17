package com.codecool.stackoverflowtw.answers.repository;

import com.codecool.stackoverflowtw.answers.model.Answer;

import java.util.List;

public interface AnswerRepository {
    List<Answer> getAll(int id);
    Answer get(int id);
    void delete(int id);
    void add(String description, int questionId);
    void update(int id, String description);
}

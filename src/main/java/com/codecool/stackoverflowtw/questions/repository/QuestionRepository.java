package com.codecool.stackoverflowtw.questions.repository;

import com.codecool.stackoverflowtw.questions.model.Question;

import java.util.List;

public interface QuestionRepository {
    List<Question> getAll();
    Question get(int id);
    void delete(int id);
    void add(String title, String description);
}

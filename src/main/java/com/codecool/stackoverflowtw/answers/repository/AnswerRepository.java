package com.codecool.stackoverflowtw.answers.repository;

import com.codecool.stackoverflowtw.answers.model.Answer;

import java.time.LocalDateTime;
import java.util.Set;

public interface AnswerRepository {
    Set<Answer> getAll(int id);
    Answer get(int id);
    void delete(int id);
    void add(String description, int questionId, LocalDateTime createdAt, int numberOfLikes, int numberOfDislikes, int userId);
    void update(int id, String description);
}

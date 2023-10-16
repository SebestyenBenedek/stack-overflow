package com.codecool.stackoverflowtw.questions.repository;

import com.codecool.stackoverflowtw.questions.controller.dto.QuestionDTO;
import java.util.List;

public interface QuestionRepository {
    List<QuestionDTO> getAll();
    QuestionDTO get(int id);
    void delete(int id);
    void add(String title, String description);
}

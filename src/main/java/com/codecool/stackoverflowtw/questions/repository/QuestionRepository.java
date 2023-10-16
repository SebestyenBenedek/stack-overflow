package com.codecool.stackoverflowtw.questions.repository;

import com.codecool.stackoverflowtw.questions.controller.dto.QuestionDTO;
import java.util.List;

public interface QuestionRepository {
    List<QuestionDTO> getAll();
    QuestionDTO get();
    void delete();
    void add();
}

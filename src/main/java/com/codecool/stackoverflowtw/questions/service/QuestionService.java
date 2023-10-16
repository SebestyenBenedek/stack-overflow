package com.codecool.stackoverflowtw.questions.service;

import com.codecool.stackoverflowtw.questions.controller.dto.NewQuestionDTO;
import com.codecool.stackoverflowtw.questions.controller.dto.QuestionDTO;

import java.util.List;

public interface QuestionService {
    List<QuestionDTO> getAllQuestions();
    QuestionDTO getQuestionById(int id);
    void deleteQuestionById(int id);
    void addNewQuestion(NewQuestionDTO question);
}

package com.codecool.stackoverflowtw.questions.service;

import com.codecool.stackoverflowtw.questions.controller.dto.QuestionDTO;

import java.util.List;

public interface QuestionService {
    List<QuestionDTO> getAllQuestions();
    QuestionDTO getQuestionById(int id);
    void deleteQuestionById(QuestionDTO question);
    void addNewQuestion(QuestionDTO question);
}

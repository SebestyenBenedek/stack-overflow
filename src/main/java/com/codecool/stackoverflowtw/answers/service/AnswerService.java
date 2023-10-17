package com.codecool.stackoverflowtw.answers.service;

import com.codecool.stackoverflowtw.answers.controller.dto.AnswerDTO;
import com.codecool.stackoverflowtw.answers.controller.dto.NewAnswerDTO;

import java.util.Set;

public interface AnswerService {
    Set<AnswerDTO> getAllAnswers(int id);
    AnswerDTO getAnswerById(int id);
    void deleteAnswerById(int id);
    void addNewAnswer(NewAnswerDTO answer);
    void updateAnswerById(int id, AnswerDTO answerDTO);
}

package com.codecool.stackoverflowtw.answers.service;

import com.codecool.stackoverflowtw.answers.controller.dto.AnswerDTO;
import com.codecool.stackoverflowtw.answers.controller.dto.NewAnswerDTO;
import com.codecool.stackoverflowtw.answers.model.Answer;
import com.codecool.stackoverflowtw.answers.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Service
public class AnswerService {
    public static final int STARTER_NUMBER_OF_LIKES = 0;
    public static final int STARTER_NUMBER_OF_DISLIKES = 0;
    private AnswerRepository answerRepository;

    @Autowired
    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public Set<AnswerDTO> getAllAnswers(int questionId) {
        Set<Answer> answers = answerRepository.getAll(questionId);
        Set<AnswerDTO> answerDTOS = new HashSet<>();

        for (Answer answer : answers) {
            answerDTOS.add(new AnswerDTO(
                    answer.getId(),
                    answer.getDescription(),
                    answer.getQuestionId(),
                    answer.getCreatedAt(),
                    answer.getNumberOfLike(),
                    answer.getNumberOfDislike(),
                    answer.getUserId()));
        }

        return answerDTOS;
    }

    public AnswerDTO getAnswerById(int id) {
        Answer answer = answerRepository.get(id);

        return new AnswerDTO(
                answer.getId(),
                answer.getDescription(),
                answer.getQuestionId(),
                answer.getCreatedAt(),
                answer.getNumberOfLike(),
                answer.getNumberOfDislike(),
                answer.getUserId());
    }

    public void deleteAnswerById(int id) {
        answerRepository.delete(id);
    }

    public void addNewAnswer(NewAnswerDTO answer) {
        answerRepository.add(answer.description(), answer.questionId(), LocalDateTime.now(), STARTER_NUMBER_OF_LIKES, STARTER_NUMBER_OF_DISLIKES, answer.userId());
    }

    public void updateAnswerById(int id, AnswerDTO answerDTO) {
        answerRepository.update(id, answerDTO.description());
    }
}

package com.codecool.stackoverflowtw.answers.service;

import com.codecool.stackoverflowtw.answers.controller.dto.AnswerDTO;
import com.codecool.stackoverflowtw.answers.controller.dto.NewAnswerDTO;
import com.codecool.stackoverflowtw.answers.model.Answer;
import com.codecool.stackoverflowtw.answers.repository.AnswerRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AnswerServiceImpl implements AnswerService {
    private AnswerRepositoryImpl answerRepository;

    @Override
    public Set<AnswerDTO> getAllAnswers(int questionId) {
        Set<Answer> answers = answerRepository.getAll(questionId);
        Set<AnswerDTO> answerDTOS = new HashSet<>();

        for (Answer answer : answers) {
            answerDTOS.add(new AnswerDTO(
                    answer.getId(),
                    answer.getDescription(),
                    answer.getQuestionId(),
                    answer.getCreated(),
                    answer.getNumberOfLike(),
                    answer.getNumberOfDislike()));
        }

        return answerDTOS;
    }

    @Override
    public AnswerDTO getAnswerById(int id) {
        Answer answer = answerRepository.get(id);

        return new AnswerDTO(
                answer.getId(),
                answer.getDescription(),
                answer.getQuestionId(),
                answer.getCreated(),
                answer.getNumberOfLike(),
                answer.getNumberOfDislike());
    }

    @Override
    public void deleteAnswerById(int id) {
        answerRepository.delete(id);
    }

    @Override
    public void addNewAnswer(NewAnswerDTO answer) {
        answerRepository.add(answer.description(), answer.questionId());
    }
}

package com.codecool.stackoverflowtw.questions.service;

import com.codecool.stackoverflowtw.questions.controller.dto.NewQuestionDTO;
import com.codecool.stackoverflowtw.questions.controller.dto.QuestionDTO;
import com.codecool.stackoverflowtw.questions.model.Question;
import com.codecool.stackoverflowtw.questions.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    public static final int STARTER_NUMBER_OF_VIEWS = 0;
    public static final int STARTER_NUMBER_OF_LIKES = 0;
    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<QuestionDTO> getAllQuestions() {
        List<Question> questions = questionRepository.getAll();
        List<QuestionDTO> questionDTOS = new ArrayList<>();

        for (Question question : questions) {
            questionDTOS.add(new QuestionDTO(
                    question.getId(),
                    question.getTitle(),
                    question.getDescription(),
                    question.getCreatedAt(),
                    question.getNumberOfAnswers(),
                    question.getNumberOfViews(),
                    question.getUserId()));
        }

        return questionDTOS;
    }

    public QuestionDTO getQuestionById(int id) {
        Question question = questionRepository.get(id);

        return new QuestionDTO(
                question.getId(),
                question.getTitle(),
                question.getDescription(),
                question.getCreatedAt(),
                question.getNumberOfAnswers(),
                question.getNumberOfViews(),
                question.getUserId());
    }

    public void deleteQuestionById(int id) {
        questionRepository.delete(id);
    }

    public void addNewQuestion(NewQuestionDTO question) {
        questionRepository.add(question.title(), question.description(), LocalDateTime.now(), STARTER_NUMBER_OF_LIKES, STARTER_NUMBER_OF_VIEWS, question.userId());
    }
}

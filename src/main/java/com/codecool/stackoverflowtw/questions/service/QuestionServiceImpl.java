package com.codecool.stackoverflowtw.questions.service;

import com.codecool.stackoverflowtw.questions.dao.QuestionsDAO;
import com.codecool.stackoverflowtw.questions.controller.dto.QuestionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionsDAO questionsDAO;

    @Autowired
    public QuestionServiceImpl(QuestionsDAO questionsDAO) {
        this.questionsDAO = questionsDAO;
    }

    public List<QuestionDTO> getAllQuestions() {
        // TODO
        return List.of(new QuestionDTO(1, "example title", "example desc", LocalDateTime.now()));
    }

    public QuestionDTO getQuestionById(int id) {
        // TODO
        //questionsDAO.sayHi();
        return new QuestionDTO(id, "example title", "example desc", LocalDateTime.now());
    }

    public boolean deleteQuestionById(int id) {
        // TODO
        return false;
    }

    public int addNewQuestion(NewQuestionDTO question) {
        // TODO
        int createdId = 0;
        return questionsDAO.;
    }
}

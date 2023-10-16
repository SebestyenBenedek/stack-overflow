package com.codecool.stackoverflowtw.questions.service;

import com.codecool.stackoverflowtw.logger.Logger;
import com.codecool.stackoverflowtw.questions.controller.dto.NewQuestionDTO;
import com.codecool.stackoverflowtw.questions.dao.QuestionsDAO;
import com.codecool.stackoverflowtw.questions.controller.dto.QuestionDTO;
import com.codecool.stackoverflowtw.questions.repository.QuestionRepository;
import com.codecool.stackoverflowtw.questions.repository.QuestionRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    private QuestionRepositoryImpl questionRepositoryImpl;
    //private QuestionsDAO questionsDAO;

    /*@Autowired
    public QuestionServiceImpl(QuestionsDAO questionsDAO) {
        this.questionsDAO = questionsDAO;
    }*/

    public List<QuestionDTO> getAllQuestions() {
        return questionRepositoryImpl.getAll();
    }

    public QuestionDTO getQuestionById(int id) {
        return questionRepositoryImpl.get(id);
    }

    public void deleteQuestionById(int id) {
        questionRepositoryImpl.delete(id);
    }

    public void addNewQuestion(NewQuestionDTO question) {
        questionRepositoryImpl.add(question.title(), question.description());
    }
}

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

    //private String dbFile;
    //private Logger logger;
    private QuestionRepositoryImpl questionRepositoryImpl;
    private QuestionsDAO questionsDAO;

    @Autowired
    public QuestionServiceImpl(QuestionsDAO questionsDAO) {
        this.questionsDAO = questionsDAO;
    }

   /* public QuestionServiceImpl(String dbFile, Logger logger) {
        this.dbFile = dbFile;
        this.logger = logger;
    }*/

    public List<QuestionDTO> getAllQuestions() {
        // TODO
        return List.of(new QuestionDTO(1, "example title", "example desc", LocalDateTime.now()));
    }

    public QuestionDTO getQuestionById(int id) {
        QuestionDTO questionById = questionRepositoryImpl.get(id);
        return new QuestionDTO(questionById.id(), questionById.title(), questionById.description(), questionById.created());
    }

    public void deleteQuestionById(int id) {
        questionRepositoryImpl.delete(id);
    }

    public void addNewQuestion(NewQuestionDTO question) {
        questionRepositoryImpl.add(question.title(), question.description());
    }
}

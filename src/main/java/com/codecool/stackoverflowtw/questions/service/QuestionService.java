package com.codecool.stackoverflowtw.questions.service;

import com.codecool.stackoverflowtw.questions.controller.dto.NewQuestionDTO;
import com.codecool.stackoverflowtw.questions.controller.dto.QuestionDTO;
import com.codecool.stackoverflowtw.questions.model.Question;
import com.codecool.stackoverflowtw.questions.repository.QuestionRepositoryImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    public static final int STARTER_NUMBER_OF_VIEWS = 0;
    public static final int STARTER_NUMBER_OF_LIKES = 0;
    private QuestionRepositoryImpl questionRepositoryImpl;
    //private QuestionsDAO questionsDAO;

    /*@Autowired
    public QuestionServiceImpl(QuestionsDAO questionsDAO) {
        this.questionsDAO = questionsDAO;
    }*/

    public List<QuestionDTO> getAllQuestions() {
        List<Question> questions = questionRepositoryImpl.getAll();
        List<QuestionDTO> questionDTOS = new ArrayList<>();

        for (Question question : questions) {
            questionDTOS.add(new QuestionDTO(
                    question.getId(),
                    question.getTitle(),
                    question.getDescription(),
                    question.getCreatedAt(),
                    question.getNumberOfAnswers(),
                    question.getNumberOfViews(),
                    question.getUserId(),
                    question.getTagId()));
        }

        return questionDTOS;
    }

    public QuestionDTO getQuestionById(int id) {
        Question question = questionRepositoryImpl.get(id);

        return new QuestionDTO(
                question.getId(),
                question.getTitle(),
                question.getDescription(),
                question.getCreatedAt(),
                question.getNumberOfAnswers(),
                question.getNumberOfViews(),
                question.getUserId(),
                question.getTagId());
    }

    public void deleteQuestionById(int id) {
        questionRepositoryImpl.delete(id);
    }

    public void addNewQuestion(NewQuestionDTO question) {
        questionRepositoryImpl.add(question.title(), question.description(), LocalDateTime.now(), STARTER_NUMBER_OF_LIKES, STARTER_NUMBER_OF_VIEWS, question.userId(), question.tagId());
    }
}

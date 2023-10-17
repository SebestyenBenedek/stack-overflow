package com.codecool.stackoverflowtw.questions.service;

import com.codecool.stackoverflowtw.questions.controller.dto.NewQuestionDTO;
import com.codecool.stackoverflowtw.questions.controller.dto.QuestionDTO;
import com.codecool.stackoverflowtw.questions.model.Question;
import com.codecool.stackoverflowtw.questions.repository.QuestionRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    private QuestionRepositoryImpl questionRepositoryImpl;
    //private QuestionsDAO questionsDAO;

    /*@Autowired
    public QuestionServiceImpl(QuestionsDAO questionsDAO) {
        this.questionsDAO = questionsDAO;
    }*/

    @Override
    public List<QuestionDTO> getAllQuestions() {
        List<Question> questions = questionRepositoryImpl.getAll();
        List<QuestionDTO> questionDTOS = new ArrayList<>();

        for (Question question : questions) {
            questionDTOS.add(new QuestionDTO(
                    question.getId(),
                    question.getTitle(),
                    question.getDescription(),
                    question.getCreated(),
                    question.getTags(),
                    question.getNumberOfAnswer(),
                    question.getNumberOfViews()));
        }

        return questionDTOS;
    }

    @Override
    public QuestionDTO getQuestionById(int id) {
        Question question = questionRepositoryImpl.get(id);

        return new QuestionDTO(
                question.getId(),
                question.getTitle(),
                question.getDescription(),
                question.getCreated(),
                question.getTags(),
                question.getNumberOfAnswer(),
                question.getNumberOfViews());
    }

    @Override
    public void deleteQuestionById(int id) {
        questionRepositoryImpl.delete(id);
    }

    @Override
    public void addNewQuestion(NewQuestionDTO question) {
        questionRepositoryImpl.add(question.title(), question.description());
    }
}

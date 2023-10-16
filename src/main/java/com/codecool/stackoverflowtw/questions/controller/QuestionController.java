package com.codecool.stackoverflowtw.questions.controller;

import com.codecool.stackoverflowtw.logger.Logger;
import com.codecool.stackoverflowtw.questions.controller.dto.NewQuestionDTO;
import com.codecool.stackoverflowtw.questions.controller.dto.QuestionDTO;
import com.codecool.stackoverflowtw.questions.service.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {
    private final QuestionServiceImpl questionServiceImpl;
    private Logger logger;

    @Autowired
    public QuestionController(QuestionServiceImpl questionServiceImpl) {
        this.questionServiceImpl = questionServiceImpl;
    }

    @GetMapping("/all")
    public ResponseEntity<List<QuestionDTO>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionServiceImpl.getAllQuestions(), HttpStatus.OK);
        } catch (Throwable e) {
            logger.logError("New question adding FAILED" + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<QuestionDTO>> getQuestionById(@PathVariable int id) {
        try {
            return new ResponseEntity<>(Optional.ofNullable(questionServiceImpl.getQuestionById(id)), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            logger.logError("New question adding FAILED" + e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Object> addNewQuestion(@RequestBody NewQuestionDTO question) {
        try {
            questionServiceImpl.addNewQuestion(question);
            logger.logInfo("New question successfully added.");
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            logger.logError("New question adding FAILED" + e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteQuestionById(@PathVariable int id) {
        try {
            questionServiceImpl.deleteQuestionById(id);
            logger.logInfo("Question successfully deleted.");
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            logger.logError("Question delete FAILED" + e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

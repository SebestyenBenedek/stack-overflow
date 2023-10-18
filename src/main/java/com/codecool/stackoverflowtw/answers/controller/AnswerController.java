package com.codecool.stackoverflowtw.answers.controller;

import com.codecool.stackoverflowtw.answers.controller.dto.AnswerDTO;
import com.codecool.stackoverflowtw.answers.controller.dto.NewAnswerDTO;
import com.codecool.stackoverflowtw.answers.service.AnswerServiceImpl;
import com.codecool.stackoverflowtw.logger.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/questions/{id}/answers")
public class AnswerController {
    private final AnswerServiceImpl answerService;
    private final Logger logger;

    @Autowired
    public AnswerController(AnswerServiceImpl answerService, Logger logger) {
        this.answerService = answerService;
        this.logger = logger;
    }

    @GetMapping("/all")
    public ResponseEntity<Set<AnswerDTO>> getAllAnswers(@PathVariable int id) {
        try {
            return new ResponseEntity<>(answerService.getAllAnswers(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Object> addNewAnswer(@RequestBody NewAnswerDTO answer) {
        try {
            answerService.addNewAnswer(answer);
            logger.logInfo("New answer successfully added.");
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAnswerById(@PathVariable int id) {
        try {
            answerService.deleteAnswerById(id);
            logger.logInfo("Answer successfully deleted.");
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateAnswerById(@PathVariable int id, @RequestBody AnswerDTO answer) {
        try {
            answerService.updateAnswerById(id, answer);
            logger.logInfo("Answer successfully updated!");
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
}

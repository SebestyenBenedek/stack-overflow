package com.codecool.stackoverflowtw.answers.controller.dto;

import java.time.LocalDateTime;

public record AnswerDTO(int id, String description, int questionId,
                        LocalDateTime created, int numberOfLike, int numberOfDislike) {
}

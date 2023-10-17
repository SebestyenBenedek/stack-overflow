package com.codecool.stackoverflowtw.questions.controller.dto;

import com.codecool.stackoverflowtw.questions.model.Tag;

import java.time.LocalDateTime;
import java.util.Set;

public record QuestionDTO(int id, String title, String description, LocalDateTime created,
                          Set<Tag> tagSet, int numberOfAnswer, int numberOfViews) {}

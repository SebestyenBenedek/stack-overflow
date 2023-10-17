package com.codecool.stackoverflowtw.users.controller.dto;

import java.util.UUID;

public record UserDTO(UUID id, String username, String password, String email) {}

package com.codecool.stackoverflowtw.users.service;

import com.codecool.stackoverflowtw.users.controller.dto.NewUserDTO;
import com.codecool.stackoverflowtw.users.controller.dto.UserDTO;
import com.codecool.stackoverflowtw.users.model.User;

import java.util.Set;
import java.util.UUID;

public interface UserService {
    Set<UserDTO> getAllUsers();
    UserDTO getUserById(UUID id);
    void deleteUserById(UUID id);
    void addNewUser(NewUserDTO userDTO);
    void updateUserById(UUID id, UserDTO userDTO);
}

package com.codecool.stackoverflowtw.users.service;

import com.codecool.stackoverflowtw.users.controller.dto.NewUserDTO;
import com.codecool.stackoverflowtw.users.controller.dto.UserDTO;
import com.codecool.stackoverflowtw.users.model.User;

import java.util.Optional;
import java.util.Set;

public interface UserService {
    Set<UserDTO> getAllUsers();
    UserDTO getUserById(int id);
    void deleteUserById(int id);
    void addNewUser(NewUserDTO userDTO);
    void updateUserById(int id, UserDTO userDTO);
    User getUserByUsername(String username);
    User validUsernameAndPassword(String username, String password);
}

package com.codecool.stackoverflowtw.users.service;

import com.codecool.stackoverflowtw.users.controller.dto.NewUserDTO;
import com.codecool.stackoverflowtw.users.controller.dto.UserDTO;
import com.codecool.stackoverflowtw.users.model.User;
import com.codecool.stackoverflowtw.users.repository.UserRepositoryImpl;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class UserServiceImpl implements UserService {
    private UserRepositoryImpl userRepository;

    public UserServiceImpl(UserRepositoryImpl userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Set<UserDTO> getAllUsers() {
        Set<User> users = userRepository.getAll();
        Set<UserDTO> userDTOS = new HashSet<>();

        for (User user : users) {
            userDTOS.add(new UserDTO(
                    user.getId(),
                    user.getUsername(),
                    user.getPassword(),
                    user.getEmail()));
        }

        return userDTOS;
    }

    @Override
    public User getUserById(UUID id) {
        return null;
    }

    @Override
    public void deleteUserById(UUID id) {

    }

    @Override
    public void addNewUser(NewUserDTO userDTO) {

    }

    @Override
    public void updateUserById(UUID id) {

    }
}

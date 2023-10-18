package com.codecool.stackoverflowtw.users.service;

import com.codecool.stackoverflowtw.users.controller.dto.NewUserDTO;
import com.codecool.stackoverflowtw.users.controller.dto.UserDTO;
import com.codecool.stackoverflowtw.users.model.User;
import com.codecool.stackoverflowtw.users.repository.UserRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    private UserRepositoryImpl userRepository;

/*
    public UserServiceImpl(UserRepositoryImpl userRepository) {
        this.userRepository = userRepository;
    }
*/

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

    public UserDTO getUserById(int id) {
        User user = userRepository.get(id);

        return new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail());
    }

    public void deleteUserById(int id) {
        userRepository.delete(id);
    }

    public void addNewUser(NewUserDTO userDTO) {
        userRepository.add(userDTO.username(), userDTO.password(), userDTO.email());
    }

    public void updateUserById(int id, UserDTO userDTO) {
        userRepository.update(id, userDTO.username(), userDTO.password(), userDTO.email());
    }
}

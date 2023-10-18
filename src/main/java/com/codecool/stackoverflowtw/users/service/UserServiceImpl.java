package com.codecool.stackoverflowtw.users.service;

import com.codecool.stackoverflowtw.users.controller.dto.NewUserDTO;
import com.codecool.stackoverflowtw.users.controller.dto.UserDTO;
import com.codecool.stackoverflowtw.users.model.User;
import com.codecool.stackoverflowtw.users.repository.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private UserRepositoryImpl userRepository;

/*
    public UserServiceImpl(UserRepositoryImpl userRepository) {
        this.userRepository = userRepository;
    }
*/

    @Autowired
    private PasswordEncoder passwordEncoder;

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
    public UserDTO getUserById(int id) {
        User user = userRepository.get(id);

        return new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail());
    }

    @Override
    public void deleteUserById(int id) {
        userRepository.delete(id);
    }

    @Override
    public void addNewUser(NewUserDTO userDTO) {
        String hashedPassword = passwordEncoder.encode(userDTO.password());
        userRepository.add(userDTO.username(), hashedPassword, userDTO.email());
    }

    @Override
    public void updateUserById(int id, UserDTO userDTO) {
        userRepository.update(id, userDTO.username(), userDTO.password(), userDTO.email());
    }

    @Override
    public User getUserByUsername(String username){
        return userRepository.findByUsername(username);
    }

    @Override
    public User validUsernameAndPassword(String username, String password){
        User user = getUserByUsername(username);

        if(passwordEncoder.matches(password, user.getPassword())){
            return user;
        }else{
            return null;
        }
    }
}

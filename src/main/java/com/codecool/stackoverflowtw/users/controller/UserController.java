package com.codecool.stackoverflowtw.users.controller;

import com.codecool.stackoverflowtw.logger.Logger;
import com.codecool.stackoverflowtw.users.controller.dto.NewUserDTO;
import com.codecool.stackoverflowtw.users.controller.dto.UserDTO;
import com.codecool.stackoverflowtw.users.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserServiceImpl userService;
    private Logger logger;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<Set<UserDTO>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserDTO>> getUserById(@PathVariable int id) {
        return new ResponseEntity<>(Optional.ofNullable(userService.getUserById(id)), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Object> addNewUser(@RequestBody NewUserDTO user) {
        userService.addNewUser(user);
        logger.logInfo("New User successfully added!");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUserById(@PathVariable int id) {
        userService.deleteUserById(id);
        logger.logInfo("User successfully deleted!");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUserById(@PathVariable int id, @RequestBody UserDTO user) {
        userService.updateUserById(id, user);
        logger.logInfo("User successfully updated!");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

package com.codecool.stackoverflowtw.users.controller;

import com.codecool.stackoverflowtw.logger.Logger;
import com.codecool.stackoverflowtw.users.controller.dto.AuthResponse;
import com.codecool.stackoverflowtw.users.controller.dto.LoginRequest;
import com.codecool.stackoverflowtw.users.model.User;
import com.codecool.stackoverflowtw.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;
    private Logger logger;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest){
        User user = userService.validUsernameAndPassword(loginRequest.username(), loginRequest.password());
        if(user != null) {
            return ResponseEntity.ok(new AuthResponse(user.getId(), user.getUsername()));
        }else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}

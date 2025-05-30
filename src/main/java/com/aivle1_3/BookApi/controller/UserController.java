package com.aivle1_3.BookApi.controller;

import com.aivle1_3.BookApi.entity.Users;
import com.aivle1_3.BookApi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user") @RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Users> register(@RequestBody Users users) {
        return ResponseEntity.ok(userService.register(users));
    }

    @PostMapping("/login")
    public ResponseEntity<Users> login(@RequestBody Users users) {
        return ResponseEntity.ok(userService.login(users.getUsername(), users.getPassword()));
    }
}

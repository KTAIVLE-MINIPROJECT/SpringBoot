package com.aivle1_3.BookApi.controller;

import com.aivle1_3.BookApi.dto.UserSignupRequestDto;
import com.aivle1_3.BookApi.dto.UserLoginRequestDto;
import com.aivle1_3.BookApi.dto.UserLoginResponseDto;
import com.aivle1_3.BookApi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private final UserService userService;

    // 회원가입
    @PostMapping("/signup")
    public UserLoginResponseDto signup(@RequestBody UserSignupRequestDto dto) {
        return userService.signup(dto);
    }

    // 로그인
    @PostMapping("/login")
    public UserLoginResponseDto login(@RequestBody UserLoginRequestDto dto) {
        return userService.login(dto);
    }
}


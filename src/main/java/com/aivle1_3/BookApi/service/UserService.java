package com.aivle1_3.BookApi.service;

import com.aivle1_3.BookApi.dto.UserSignupRequestDto;
import com.aivle1_3.BookApi.dto.UserLoginRequestDto;
import com.aivle1_3.BookApi.dto.UserLoginResponseDto;
import com.aivle1_3.BookApi.entity.User;
import com.aivle1_3.BookApi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // 회원가입
    public UserLoginResponseDto signup(UserSignupRequestDto dto) {
        if (userRepository.findByUserid(dto.getUserid()).isPresent()) {
            throw new RuntimeException("이미 존재하는 아이디입니다.");
        }

        User user = User.builder()
                .userid(dto.getUserid())
                .password(dto.getPassword())
                .nickname(dto.getName())
                .build();

        User savedUser = userRepository.save(user);

        return new UserLoginResponseDto(savedUser.getId(), savedUser.getUserid(), savedUser.getNickname());
    }

    // 로그인
    public UserLoginResponseDto login(UserLoginRequestDto dto) {
        User user = userRepository.findByUserid(dto.getUserid())
                .orElseThrow(() -> new RuntimeException("존재하지 않는 아이디입니다."));

        if (!dto.getPassword().equals(user.getPassword())) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }

        return new UserLoginResponseDto(user.getId(), user.getUserid(), user.getNickname());
    }
}


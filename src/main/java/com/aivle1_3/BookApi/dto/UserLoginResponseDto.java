package com.aivle1_3.BookApi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserLoginResponseDto {
    private Long id;
    private String userid;
    private String nickname;
}

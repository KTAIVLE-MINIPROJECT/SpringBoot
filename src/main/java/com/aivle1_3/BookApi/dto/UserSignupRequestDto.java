package com.aivle1_3.BookApi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserSignupRequestDto {
    private String userid;
    private String password;
    private String name;
}


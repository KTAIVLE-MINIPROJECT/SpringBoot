package com.aivle1_3.BookApi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class BookUpdateResponseDto {
    private Long id;
    private LocalDateTime updatedAt;
}

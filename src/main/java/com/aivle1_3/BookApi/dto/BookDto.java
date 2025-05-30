package com.aivle1_3.BookApi.dto;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class BookDto {
    private Long id;
    private String title;
    private String author;
    private String publisher;
    private String content;
    private String coverUrl;
    private Long userId;

    @JsonProperty("category_id")
    private Long categoryId;
}


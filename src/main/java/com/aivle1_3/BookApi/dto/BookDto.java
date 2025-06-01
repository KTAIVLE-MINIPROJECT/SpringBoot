package com.aivle1_3.BookApi.dto;

import com.aivle1_3.BookApi.entity.Book;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonProperty;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class BookDto {
    private Long id;
    private String title;
    private String author;
    private String publisher;
    private String content;
    private String coverUrl;

    @JsonProperty("category_id")
    private Long categoryId;

    @JsonProperty("created_by_Userid")
    private String createdByUserid; // 등록자 아이디(로그인용 id, 즉 userid)

    // Book → BookDto 변환 메서드
    public static BookDto from(Book book) {
        return BookDto.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .publisher(book.getPublisher())
                .content(book.getContent())
                .coverUrl(book.getCoverUrl())
                .categoryId(book.getCategoryId())
                .createdByUserid(
                        book.getCreatedBy() != null ? book.getCreatedBy().getUserid() : null
                )
                .build();
    }
}



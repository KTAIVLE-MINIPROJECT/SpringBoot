package com.aivle1_3.BookApi.dto;

import com.aivle1_3.BookApi.entity.Book;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    private Long id;
    private String title;
    private String author;
    private String publisher;
    private String content;
    private String coverUrl;
    private Long categoryId;
    private Long userid;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // 엔티티(Book) -> DTO(BookDto) 변환 메소드
    public static BookDto from(Book book) {
        return new BookDto(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getPublisher(),
                book.getContent(),
                book.getCoverUrl(),
                book.getCategoryId(),
                book.getUserId(),
                book.getCreatedAt(),
                book.getUpdatedAt()
        );
    }
}




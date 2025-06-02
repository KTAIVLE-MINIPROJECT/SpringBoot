package com.aivle1_3.BookApi.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.*;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 도서 고유번호

    @CreationTimestamp
    private LocalDateTime createdAt; // 도서 등록일

    @UpdateTimestamp
    private LocalDateTime updatedAt; // 도서 수정일


    @Column(nullable = false)
    private String title;      // 도서 제목

    @Column(nullable = false)
    private String author;     // 도서 저자

    @Column(nullable = false)
    private String publisher;  // 출판사


    private String content;    // 도서 소개

    @Column(length = 500)
    private String coverUrl;   // 표지 이미지 URL

    @JsonProperty("category_id")
    private Long categoryId; // 카테고리 외래키

    @Column(nullable = false)
    private Long userId;
}
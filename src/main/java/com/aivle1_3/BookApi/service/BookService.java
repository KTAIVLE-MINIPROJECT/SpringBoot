package com.aivle1_3.BookApi.service;

import com.aivle1_3.BookApi.dto.BookDto;
import com.aivle1_3.BookApi.entity.*;
import com.aivle1_3.BookApi.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    // 도서 등록
    public Book save(BookDto dto, Long userId) {
        if (userId == null) {
            throw new RuntimeException("로그인을 해주세요.");
        }
        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setPublisher(dto.getPublisher());
        book.setContent(dto.getContent());
        if (dto.getCoverUrl() != null) {
            book.setCoverUrl(dto.getCoverUrl());
        }
        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 category ID 입니다."));
        book.setCategoryId(category.getId());
        book.setUserId(userId);
        return bookRepository.save(book);
    }

    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    // 도서 수정
    public Book update(BookDto dto, Long userId) {
        if (userId == null) {
            throw new RuntimeException("로그인을 해주세요.");
        }
        Book book = bookRepository.findById(dto.getId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 book ID 입니다."));
        if (!book.getUserId().equals(userId)) {
            throw new RuntimeException("수정 권한이 없습니다.");
        }
        if (dto.getTitle() != null) book.setTitle(dto.getTitle());
        if (dto.getAuthor() != null) book.setAuthor(dto.getAuthor());
        if (dto.getPublisher() != null) book.setPublisher(dto.getPublisher());
        if (dto.getContent() != null) book.setContent(dto.getContent());
        if (dto.getCoverUrl() != null) book.setCoverUrl(dto.getCoverUrl());
        if (dto.getCategoryId() != null) book.setCategoryId(dto.getCategoryId());
        bookRepository.save(book);
        return book;
    }

    // 도서 삭제
    public Book delete(Long id, Long userId) {
        if (userId == null) {
            throw new RuntimeException("로그인을 해주세요.");
        }
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 book ID 입니다."));
        if (!book.getUserId().equals(userId)) {
            throw new RuntimeException("삭제 권한이 없습니다.");
        }
        bookRepository.delete(book);
        return book;
    }
}


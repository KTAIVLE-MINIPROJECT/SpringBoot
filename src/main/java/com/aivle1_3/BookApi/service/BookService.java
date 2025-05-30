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

    public Book save(BookDto dto) {
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
        book.setUserId(dto.getUserId());
        return bookRepository.save(book);
    }

    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    public Book update(BookDto dto) {

        Book book = bookRepository.findById(dto.getId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 book ID 입니다."));

        // ✅ 사용자 권한 확인
        if (!book.getUserId().equals(dto.getUserId())) {
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

    public Book delete(BookDto dto) {
        Book book = bookRepository.findById(dto.getId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 book ID 입니다."));

        // ✅ 사용자 권한 확인
        if (!book.getUserId().equals(dto.getUserId())) {
            throw new RuntimeException("삭제 권한이 없습니다.");
        }

        bookRepository.delete(book);

        return book;
    }
}

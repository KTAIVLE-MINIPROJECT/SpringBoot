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
    private final UserRepository userRepository;

    // 전체 조회 (비로그인 허용)
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    // 도서 등록 (로그인 필요)
    public Book save(BookDto dto, String userid) {
        if (userid == null || userid.isBlank()) {
            throw new RuntimeException("로그인이 필요합니다.");
        }
        User user = userRepository.findByUserid(userid);
        if (user == null) throw new RuntimeException("로그인이 필요합니다.");

        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setPublisher(dto.getPublisher());
        book.setContent(dto.getContent());
        if (dto.getCoverUrl() != null) book.setCoverUrl(dto.getCoverUrl());

        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 category ID 입니다."));
        book.setCategoryId(category.getId());

        // 등록자 정보 저장
        book.setCreatedBy(user);

        return bookRepository.save(book);
    }

    // 단일 조회
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    // 도서 수정 (등록자만 가능)
    public Book update(BookDto dto, String userid) {
        if (userid == null || userid.isBlank()) {
            throw new RuntimeException("로그인이 필요합니다.");
        }
        User user = userRepository.findByUserid(userid);
        if (user == null) throw new RuntimeException("로그인이 필요합니다.");

        Book book = bookRepository.findById(dto.getId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 book ID 입니다."));

        if (!book.getCreatedBy().getId().equals(user.getId())) {
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

    // 도서 삭제 (등록자만 가능)
    public Book delete(Long bookId, String userid) {
        if (userid == null || userid.isBlank()) {
            throw new RuntimeException("로그인이 필요합니다.");
        }
        User user = userRepository.findByUserid(userid);
        if (user == null) throw new RuntimeException("로그인이 필요합니다.");

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 book ID 입니다."));

        if (!book.getCreatedBy().getId().equals(user.getId())) {
            throw new RuntimeException("삭제 권한이 없습니다.");
        }

        bookRepository.delete(book);
        return book;
    }
}

package com.aivle1_3.BookApi.controller;

import com.aivle1_3.BookApi.dto.BookDeleteResponseDto;
import com.aivle1_3.BookApi.dto.BookDto;
import com.aivle1_3.BookApi.dto.BookUpdateResponseDto;
import com.aivle1_3.BookApi.entity.Book;
import com.aivle1_3.BookApi.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    // 전체 도서 목록 조회
    @GetMapping
    public List<BookDto> allBooks() {
        return bookService.getAll().stream()
                .map(BookDto::from)
                .collect(Collectors.toList());
    }

    // 도서 등록
    @PostMapping
    public BookDto addBook(@RequestBody BookDto dto, @RequestParam Long userId) {
        Book book = bookService.save(dto, userId);
        return BookDto.from(book);
    }

    // 도서 상세 조회
    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable Long id) {
        Optional<Book> bookOpt = bookService.findById(id);
        if (bookOpt.isPresent()) {
            BookDto dto = BookDto.from(bookOpt.get());
            return ResponseEntity.ok(dto);
        } else {
            Map<String, String> error = new HashMap<>();
            error.put("message", "존재하지 않는 정보입니다.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    @PutMapping
    public BookUpdateResponseDto updateBook(@RequestBody BookDto dto, @RequestParam(required = false) Long userId) {
        Book book = bookService.update(dto, userId);
        return new BookUpdateResponseDto(book.getId(), book.getUpdatedAt());
    }

    @DeleteMapping
    public BookDeleteResponseDto deleteBook(@RequestParam Long id, @RequestParam(required = false) Long userId) {
        Book book = bookService.delete(id, userId);
        return new BookDeleteResponseDto(book.getId());
    }
}



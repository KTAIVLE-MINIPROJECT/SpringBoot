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

    @GetMapping
    public List<BookDto> allBooks() {
        return bookService.getAll().stream()
                .map(BookDto::from)
                .collect(Collectors.toList());
    }

    @PostMapping
    public Book addBook(@RequestBody BookDto dto, @RequestParam String userid) {
        return bookService.save(dto, userid);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getBookById(@PathVariable Long id) {
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
    public BookUpdateResponseDto updateBook(@RequestBody BookDto dto, @RequestParam String userid) {
        Book book = bookService.update(dto, userid);

        return new BookUpdateResponseDto(book.getId(), book.getUpdatedAt());
    }

    @DeleteMapping
    public BookDeleteResponseDto deleteBook(@RequestBody BookDto dto, @RequestParam String userid) {
        Book book = bookService.delete(dto.getId(), userid);

        return new BookDeleteResponseDto(book.getId());
    }
}

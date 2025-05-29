package com.aivle1_3.BookApi.controller;

import com.aivle1_3.BookApi.dto.BookDto;
import com.aivle1_3.BookApi.entity.Book;
import com.aivle1_3.BookApi.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    public List<Book> allBooks() {
        return bookService.getAll();
    }

    @PostMapping
    public Book addBook(@RequestBody BookDto dto) {
        return bookService.save(dto);
    }
}

package com.aivle1_3.BookApi.service;

import com.aivle1_3.BookApi.dto.BookDto;
import com.aivle1_3.BookApi.entity.Book;
import com.aivle1_3.BookApi.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public Book save(BookDto dto) {
        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        return bookRepository.save(book);
    }
}

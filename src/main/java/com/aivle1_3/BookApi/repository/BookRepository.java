package com.aivle1_3.BookApi.repository;

import com.aivle1_3.BookApi.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
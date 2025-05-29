package com.aivle1_3.BookApi.repository;

import com.aivle1_3.BookApi.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

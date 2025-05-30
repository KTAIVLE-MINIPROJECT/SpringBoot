package com.aivle1_3.BookApi.controller;

import com.aivle1_3.BookApi.entity.Category;
import com.aivle1_3.BookApi.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public List<Category> allBooks() {
        return categoryService.getAll();
    }

}

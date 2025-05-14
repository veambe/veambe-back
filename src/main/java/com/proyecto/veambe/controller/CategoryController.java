package com.proyecto.veambe.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.veambe.model.Category;
import com.proyecto.veambe.repository.CategoryRepository;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
  private final CategoryRepository categoryRepository;

  public CategoryController(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  @PostMapping
  public Category createCategory(@RequestBody Category category) {
    return categoryRepository.save(category);
  }

  @GetMapping
  public List<Category> getAllCategories() {
    return categoryRepository.findAll();
  }
}

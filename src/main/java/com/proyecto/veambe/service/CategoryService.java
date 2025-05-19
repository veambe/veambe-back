package com.proyecto.veambe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.proyecto.veambe.model.Category;
import com.proyecto.veambe.repository.CategoryRepository;

@Service
public class CategoryService {
  private final CategoryRepository categoryRepository;

  public CategoryService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  public ResponseEntity<Object> createCategory(Category category) {

    return new ResponseEntity<>(categoryRepository.save(category), HttpStatus.CREATED);
  }

  public List<Category> getAllCategories() {
    return this.categoryRepository.findAll();
  }

 
  public ResponseEntity<Object> getCategoryById(Integer id) {
    Optional<Category> categoryOptional = categoryRepository.findById(id);
    return ResponseEntity.ok(categoryOptional.get());
  }

  public ResponseEntity<Object> getCategoryByName(String categoryName) {
    Optional<Category> categoryOptional = Optional.ofNullable(categoryRepository.findByName(categoryName));
    Category category = categoryOptional.get();
    return ResponseEntity.ok(category);
  }
}

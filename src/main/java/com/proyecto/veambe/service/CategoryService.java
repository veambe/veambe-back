package com.proyecto.veambe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.proyecto.veambe.model.Category;
import com.proyecto.veambe.repository.CategoryRepository;

@Service
public class CategoryService {

  private final CategoryRepository categoryRepository;

  public CategoryService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  public Category createCategory(Category category) {

    return categoryRepository.save(category);
  }

  public List<Category> getAllCategories() {
    return this.categoryRepository.findAll();
  }

  public Category getCategoryById(Integer id) {
   return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
   
  }

  public Category getCategoryByName(String categoryName) {
    return Optional.ofNullable(categoryRepository.findByName(categoryName)).orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
 
  }
}

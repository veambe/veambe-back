package com.proyecto.veambe.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.veambe.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

  Category findByName(String categoryName);

  @SuppressWarnings("null")
  Optional<Category> findById(@SuppressWarnings("null") Integer id);

}

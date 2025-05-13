package com.proyecto.veambe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.veambe.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}

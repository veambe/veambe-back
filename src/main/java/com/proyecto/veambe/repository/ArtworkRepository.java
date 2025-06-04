package com.proyecto.veambe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.veambe.model.Artwork;

public interface ArtworkRepository extends JpaRepository<Artwork, Integer> {
  List<Artwork> findByCategoryName(String categoryName);

}

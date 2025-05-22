package com.proyecto.veambe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.veambe.model.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {
  List<Image> findByArtworkId(Integer artworkId);
}


package com.proyecto.veambe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.veambe.model.Image;

public interface ImageRepository extends JpaRepository<Image, Integer> {
List<Image> findByArtworkId(Integer artworkId);
}

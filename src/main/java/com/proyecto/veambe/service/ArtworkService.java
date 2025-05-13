package com.proyecto.veambe.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.proyecto.veambe.model.Admin;
import com.proyecto.veambe.model.Artwork;
import com.proyecto.veambe.model.Category;
import com.proyecto.veambe.repository.AdminRepository;
import com.proyecto.veambe.repository.ArtworkRepository;
import com.proyecto.veambe.repository.CategoryRepository;

@Service
public class ArtworkService {

  private final ArtworkRepository artworkRepository;
  private final AdminRepository adminRepository;
  private final CategoryRepository categoryRepository;

  public ArtworkService(
      ArtworkRepository artworkRepository,
      AdminRepository adminRepository,
      CategoryRepository categoryRepository) {
    this.artworkRepository = artworkRepository;
    this.adminRepository = adminRepository;
    this.categoryRepository = categoryRepository;
  }

  public ResponseEntity<Object> createArtwork(Artwork artwork, Integer adminId, Integer categoryId) {
    Admin admin = adminRepository.findById(adminId)
        .orElseThrow(() -> new RuntimeException("Admin not found"));

    Category category = categoryRepository.findById(categoryId)
        .orElseThrow(() -> new RuntimeException("Category not found"));

    artwork.setAdmin(admin);
    artwork.setCategory(category);

    artworkRepository.save(artwork);

    return new ResponseEntity<>(artwork, HttpStatus.CREATED);
  }

}

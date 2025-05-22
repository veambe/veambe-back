package com.proyecto.veambe.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.proyecto.veambe.model.Admin;
import com.proyecto.veambe.model.Artwork;
import com.proyecto.veambe.model.Category;
import com.proyecto.veambe.model.Image;
import com.proyecto.veambe.repository.AdminRepository;
import com.proyecto.veambe.repository.ArtworkRepository;
import com.proyecto.veambe.repository.CategoryRepository;
import com.proyecto.veambe.repository.ImageRepository;

@Service
public class ArtworkService {

  private final ArtworkRepository artworkRepository;
  private final AdminRepository adminRepository;
  private final CategoryRepository categoryRepository;
  private final ImageRepository imageRepository;

  public ArtworkService(
      ArtworkRepository artworkRepository,
      AdminRepository adminRepository,
      CategoryRepository categoryRepository,
      ImageRepository imageRepository) {
    this.artworkRepository = artworkRepository;
    this.adminRepository = adminRepository;
    this.categoryRepository = categoryRepository;
    this.imageRepository = imageRepository;
  }

  public ResponseEntity<Object> createArtwork(Artwork artwork, Integer adminId, Integer categoryId) {
    Admin admin = adminRepository.findById(adminId)
        .orElseThrow(() -> new RuntimeException("No se encontró el administrador"));

    Category category = categoryRepository.findById(categoryId)
        .orElseThrow(() -> new RuntimeException("No se encontró la categoría"));

    artwork.setAdmin(admin);
    artwork.setCategory(category);

    artworkRepository.save(artwork);

    return new ResponseEntity<>(artwork, HttpStatus.CREATED);
  }

  public List<Artwork> getAllArtworks(){
    return this.artworkRepository.findAll();
  }

  public List<Artwork> getArtworksByCategory(String categoryName){
    return artworkRepository.findByCategoryName(categoryName);
  }

  public Optional<Artwork> getArtworkById(Integer id){
    return artworkRepository.findById(id);
  }

 public void deleteArtworkById(Integer artworkId) {
    List<Image> images = imageRepository.findByArtworkId(artworkId);

    for (Image img : images) {
        try {
            Path filePath = Paths.get(img.getFilePath().replace("\\", "/"));

            Path fullPath = Paths.get("uploads").resolve(filePath.getFileName());

            Files.deleteIfExists(fullPath);
        } catch (IOException e) {
            System.err.println("Failed to delete file: " + img.getFilePath());
        }

        imageRepository.delete(img);
    }

    artworkRepository.deleteById(artworkId);
}
}

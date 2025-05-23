package com.proyecto.veambe.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.proyecto.veambe.model.Artwork;
import com.proyecto.veambe.model.Image;
import com.proyecto.veambe.repository.ArtworkRepository;
import com.proyecto.veambe.repository.ImageRepository;

@Service
public class ImageService {

  @Value("${upload.dir}")
  private String uploadDir;

  private final ImageRepository imageRepository;
  private final ArtworkRepository artworkRepository;

  public ImageService(ImageRepository imageRepository, ArtworkRepository artworkRepository) {
    this.imageRepository = imageRepository;
    this.artworkRepository = artworkRepository;
  }

  public List<Image> getAllImages() {
    return imageRepository.findAll();
  }

  public Image uploadImageFile(Integer artworkId, MultipartFile file) throws IOException {
    Artwork artwork = artworkRepository.findById(artworkId)
        .orElseThrow(() -> new RuntimeException("No se encontró la obra"));

    String filename = UUID.randomUUID() + "_" + file.getOriginalFilename(); 
                                                                            
                                                                            
    Path filePath = Paths.get(uploadDir, filename);
    Files.createDirectories(filePath.getParent());
    Files.copy(file.getInputStream(), filePath);

    Image image = new Image(); 
    image.setFilePath("uploads/" + filename); 
    image.setArtwork(artwork); 
    return imageRepository.save(image); 
  }

  public Image addImageToArtwork(Integer artworkId, Image image) {
    Artwork artwork = artworkRepository.findById(artworkId)
        .orElseThrow(() -> new RuntimeException("No se encontró la obra"));
    image.setArtwork(artwork);
    return imageRepository.save(image);
  }

  public List<Image> getImagesByArtworkId(Integer artworkId) {
    return imageRepository.findByArtworkId(artworkId);
  }

}

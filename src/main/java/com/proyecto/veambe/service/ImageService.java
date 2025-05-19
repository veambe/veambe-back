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

  public Image uploadImageFile(Integer artworkId, MultipartFile file) throws IOException {
    Artwork artwork = artworkRepository.findById(artworkId)
        .orElseThrow(() -> new RuntimeException("No se encontró la obra"));

        // esto lo guarda en el disco local
    String filename = UUID.randomUUID() + "_" + file.getOriginalFilename();  // esto genera un nombre nuevo que lo añade al del archivo para que no se repitan los nombres
    Files.createDirectories(Paths.get(uploadDir));
    Path filePath = Paths.get(uploadDir, filename);
    Files.createDirectories(filePath.getParent());
    Files.copy(file.getInputStream(), filePath);

    // aquí guardamos en la base de datos
    Image image = new Image(); //creamos una nueva entidad imagen
    image.setFilePath(filePath.toString()); // asignamos una ruta
    image.setArtwork(artwork); // juntamos la imagen al artwork
    return imageRepository.save(image); //guardamos en la bd
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

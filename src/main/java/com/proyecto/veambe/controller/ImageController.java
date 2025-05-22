package com.proyecto.veambe.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.proyecto.veambe.model.Image;
import com.proyecto.veambe.service.ImageService;

@RestController
@RequestMapping("/api/v1/images")
public class ImageController {

  private final ImageService imageService;

  public ImageController(ImageService imageService) {
    this.imageService = imageService;
  }

  @PostMapping("/{artworkId}")
  public ResponseEntity<Image> uploadImage(@PathVariable Integer artworkId, @RequestBody Image image) {
    Image savedImage = imageService.addImageToArtwork(artworkId, image);
    return new ResponseEntity<>(savedImage, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<Image>> getAllImages() {
    List<Image> images = imageService.getAllImages();
    return ResponseEntity.ok(images);
  }

  @GetMapping("/obra/{artworkId}")
  public ResponseEntity<List<Image>> getImagesByArtwork(@PathVariable Integer artworkId) {
    List<Image> images = imageService.getImagesByArtworkId(artworkId);
    return ResponseEntity.ok(images);
  }

    @PostMapping(value = "/upload/{artworkId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Image> uploadFile(
        @PathVariable Integer artworkId,
        @RequestParam("file") MultipartFile file) {

        try {
            Image savedImage = imageService.uploadImageFile(artworkId, file);
            return new ResponseEntity<>(savedImage, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

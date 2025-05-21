package com.proyecto.veambe.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.veambe.model.Artwork;
import com.proyecto.veambe.service.ArtworkService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("api/v1/trabajo")
public class ArtworkController {

  private final ArtworkService artworkService;

  public ArtworkController(ArtworkService artworkService) {
    this.artworkService = artworkService;

  }

  @PostMapping("/{adminId}")
  public ResponseEntity<Object> createArtwork(@PathVariable Integer adminId, @RequestBody Artwork artwork) {
     if (artwork.getCategory() == null || artwork.getCategory().getId() == 0) {
        return new ResponseEntity<>("La categoría es obligatoria", HttpStatus.BAD_REQUEST);
    }
    Integer categoryId = artwork.getCategory().getId();
    return artworkService.createArtwork(artwork, adminId, categoryId);
  }

  @GetMapping()
  public List<Artwork> getAllArtworks() {
    return artworkService.getAllArtworks();
  }

  @GetMapping("/categoria/{categoryName}")
  public List<Artwork> getArtworksByCategory(@PathVariable String categoryName) {
    return artworkService.getArtworksByCategory(categoryName);
  }

  @GetMapping("/obra/{artworkId}")
  public Optional<Artwork> getArtworkById(@PathVariable Integer artworkId) {
    return artworkService.getArtworkById(artworkId);
  }

}

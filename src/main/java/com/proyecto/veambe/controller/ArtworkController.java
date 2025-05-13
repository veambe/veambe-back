package com.proyecto.veambe.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.veambe.model.Artwork;
import com.proyecto.veambe.service.ArtworkService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("api/v1/work")
public class ArtworkController {

  private final ArtworkService artworkService;

  public ArtworkController(ArtworkService artworkService){
    this.artworkService = artworkService;
  }

  @PostMapping("/{adminId}")
  public ResponseEntity<Object> createArtwork(@PathVariable Integer adminId, @RequestBody Artwork artwork){
  Integer categoryId = artwork.getCategory().getId(); 
   return artworkService.createArtwork(artwork, adminId, categoryId);
  }


}

package com.proyecto.veambe.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "images")
public class Image {
  @Id
  @SequenceGenerator(name = "image_id_sequence", sequenceName = "image_id_sequence", allocationSize = 1, initialValue = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "image_id_sequence")
  private int id;

  @Column(nullable = false)
  private String filePath;

  @ManyToOne
  @JoinColumn(name = "artwork_id", nullable = false)
  private Artwork artwork;

  public Image() {
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFilePath() {
    return this.filePath;
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }

  public Artwork getArtwork() {
    return this.artwork;
  }

  public void setArtwork(Artwork artwork) {
    this.artwork = artwork;
  }

}

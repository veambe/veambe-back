package com.proyecto.veambe.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "artworks")
public class Artwork {
  @Id
  @SequenceGenerator(name = "artwork_id_sequence", sequenceName = "artwork_id_sequence", allocationSize = 1, initialValue = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "artwork_id_sequence")
  private int id;

  @Column
  private String title;

  @Column(columnDefinition = "TEXT")
  private String description;

  @ManyToOne
  @JoinColumn(name = "admin_id", nullable = false)
  @JsonIgnore
  private Admin admin;

  @ManyToOne
  @JoinColumn(name = "category_id", nullable = false)
  @JsonBackReference
  private Category category;

  @OneToMany(mappedBy = "artwork", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Image> images;

  public Artwork() {
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Admin getAdmin() {
    return this.admin;
  }

  public void setAdmin(Admin admin) {
    this.admin = admin;
  }

  public Category getCategory() {
    return this.category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public List<Image> getImages() {
    return this.images;
  }

  public void setImages(List<Image> images) {
    this.images = images;
  }

}

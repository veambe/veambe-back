package com.proyecto.veambe.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;

@Entity
@Table(name = "categories")
public class Category {
  @Id
  @SequenceGenerator(name = "category_id_sequence", sequenceName = "category_id_sequence", allocationSize = 1, initialValue = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_id_sequence")
  private int id;

  @Column(nullable = false, unique = true)
  String name;

  @OneToMany(mappedBy = "category")
  private List<Artwork> artworks;

  public Category() {
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Artwork> getArtworks() {
    return this.artworks;
  }

  public void setArtworks(List<Artwork> artworks) {
    this.artworks = artworks;
  }

}

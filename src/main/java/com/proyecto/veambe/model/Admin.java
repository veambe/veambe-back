package com.proyecto.veambe.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Admin {
  @Id
  @SequenceGenerator(name = "article_id_sequence", sequenceName = "article_id_sequence", allocationSize = 1, initialValue = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "article_id_sequence")
  @SequenceGenerator(name = "article_id_sequence", sequenceName = "article_id_sequence", allocationSize = 1, initialValue = 1)
  int id;

  @Column
  String name;

  @Column
  String email;

  @Column
  String password;

  public Admin() {
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

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}

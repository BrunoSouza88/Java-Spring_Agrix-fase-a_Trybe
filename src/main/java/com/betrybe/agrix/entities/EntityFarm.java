package com.betrybe.agrix.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * javadoc.
 */
@Entity
@Table(name = "farms")
public class EntityFarm {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private Long id;

  private String name;

  private Double size;

  public EntityFarm() {}

  /**
 * javadoc.
 */
  public EntityFarm(Long id, String name, Double size) {
    this.id = id;

    this.name = name;

    this.size = size;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long newId) {
    this.id = newId;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String newName) {
    this.name = newName;
  }

  public Double getSize() {
    return this.size;
  }

  public void setSize(Double newSize) {
    this.size = newSize;
  }
}

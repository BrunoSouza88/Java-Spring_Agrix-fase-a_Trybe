package com.betrybe.agrix.dto;

import com.betrybe.agrix.entities.EntityCrop;
import com.betrybe.agrix.entities.EntityFarm;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * javadoc.
 */
public record CropDto(
    Long id,
    String name,
    Double plantedArea,
    Long farmId) {
  public EntityCrop toCrop(EntityFarm farmId) {
    return new EntityCrop(id, name, plantedArea, farmId);
  }
}

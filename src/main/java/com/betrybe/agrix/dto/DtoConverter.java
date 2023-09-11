package com.betrybe.agrix.dto;

import com.betrybe.agrix.entities.EntityFarm;

/**
 * javadoc.
 */
public class DtoConverter {
  
  public static FarmDto modelToDto(EntityFarm farm) {
    return new FarmDto(farm.getId(), farm.getName(), farm.getSize());
  }

  /**
 * javadoc.
 */
  public static EntityFarm dtoToModel(FarmDto dto) {
    EntityFarm farm = new EntityFarm();

    farm.setId(dto.id());
    farm.setName(dto.name());
    farm.setSize(dto.size());

    return farm;
  }
}

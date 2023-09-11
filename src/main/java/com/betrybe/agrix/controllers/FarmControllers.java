package com.betrybe.agrix.controllers;

import com.betrybe.agrix.dto.DtoConverter;
import com.betrybe.agrix.dto.FarmDto;
import com.betrybe.agrix.entities.EntityFarm;
import com.betrybe.agrix.services.FarmService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * javadoc.
 */
@RestController
@RequestMapping(value = "/farms")
public class FarmControllers {
  
  @Autowired
  private FarmService farmService;

  @Autowired
  public FarmControllers(FarmService farmService) {
    this.farmService = farmService;
  }

  /**
 * javadoc.
 */

  @PostMapping()
  public ResponseEntity<EntityFarm> createFarm(@RequestBody FarmDto newFarm) {
    EntityFarm farm = DtoConverter.dtoToModel(newFarm);

    return ResponseEntity.status(HttpStatus.CREATED).body(farmService.insertFarm(newFarm.toFarm()));
  }

  /**
 * javadoc.
 */
  @GetMapping("/{id}")
  public ResponseEntity<FarmDto> getFarmById(@PathVariable Long id) {
    EntityFarm response = farmService.getFarmbyId(id);
    return ResponseEntity.status(HttpStatus.OK).body(DtoConverter.modelToDto(response));
  }

  /**
 * javadoc.
 */
  @GetMapping()
  public List<FarmDto> getAllFarms() {
    List<EntityFarm> allFarms = farmService.getAllFarms();

    return allFarms.stream()
    .map((farm) -> new FarmDto(
      farm.getId(),
      farm.getName(),
      farm.getSize()))
      .collect(Collectors.toList());
  }
}

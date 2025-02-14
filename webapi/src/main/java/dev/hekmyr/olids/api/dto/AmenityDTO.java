package dev.hekmyr.olids.api.dto;

import dev.hekmyr.olids.api.entity.Amenity;
import java.util.UUID;

public class AmenityDTO {

  private UUID id;
  private boolean airConditioningAvailable;
  private boolean terraceAvailable;
  private boolean gardenAvailable;
  private boolean poolAvailable;
  private boolean hotTubAvailable;
  private boolean evChargerAvailable;
  private boolean indoorFireplaceAvailable;
  private boolean outdoorFireplaceAvailable;
  private boolean dedicatedWorkspaceAvailable;
  private boolean gymAvailable;

  public AmenityDTO() {}

  public AmenityDTO(Amenity model) {
    this.id = model.getId();
    this.airConditioningAvailable = model.isAirConditioningAvailable();
    this.terraceAvailable = model.isTerraceAvailable();
    this.gardenAvailable = model.isGardenAvailable();
    this.poolAvailable = model.isPoolAvailable();
    this.hotTubAvailable = model.isHotTubAvailable();
    this.evChargerAvailable = model.isEvChargerAvailable();
    this.indoorFireplaceAvailable = model.isIndoorFireplaceAvailable();
    this.outdoorFireplaceAvailable = model.isOutdoorFireplaceAvailable();
    this.dedicatedWorkspaceAvailable = model.isDedicatedWorkspaceAvailable();
    this.gymAvailable = model.isGymAvailable();
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public boolean isAirConditioningAvailable() {
    return airConditioningAvailable;
  }

  public void setAirConditioningAvailable(boolean airConditioningAvailable) {
    this.airConditioningAvailable = airConditioningAvailable;
  }

  public boolean isTerraceAvailable() {
    return terraceAvailable;
  }

  public void setTerraceAvailable(boolean terraceAvailable) {
    this.terraceAvailable = terraceAvailable;
  }

  public boolean isGardenAvailable() {
    return gardenAvailable;
  }

  public void setGardenAvailable(boolean gardenAvailable) {
    this.gardenAvailable = gardenAvailable;
  }

  public boolean isPoolAvailable() {
    return poolAvailable;
  }

  public void setPoolAvailable(boolean poolAvailable) {
    this.poolAvailable = poolAvailable;
  }

  public boolean isHotTubAvailable() {
    return hotTubAvailable;
  }

  public void setHotTubAvailable(boolean hotTubAvailable) {
    this.hotTubAvailable = hotTubAvailable;
  }

  public boolean isEvChargerAvailable() {
    return evChargerAvailable;
  }

  public void setEvChargerAvailable(boolean evChargerAvailable) {
    this.evChargerAvailable = evChargerAvailable;
  }

  public boolean isIndoorFireplaceAvailable() {
    return indoorFireplaceAvailable;
  }

  public void setIndoorFireplaceAvailable(boolean indoorFireplaceAvailable) {
    this.indoorFireplaceAvailable = indoorFireplaceAvailable;
  }

  public boolean isOutdoorFireplaceAvailable() {
    return outdoorFireplaceAvailable;
  }

  public void setOutdoorFireplaceAvailable(boolean outdoorFireplaceAvailable) {
    this.outdoorFireplaceAvailable = outdoorFireplaceAvailable;
  }

  public boolean isDedicatedWorkspaceAvailable() {
    return dedicatedWorkspaceAvailable;
  }

  public void setDedicatedWorkspaceAvailable(
    boolean dedicatedWorkspaceAvailable
  ) {
    this.dedicatedWorkspaceAvailable = dedicatedWorkspaceAvailable;
  }

  public boolean isGymAvailable() {
    return gymAvailable;
  }

  public void setGymAvailable(boolean gymAvailable) {
    this.gymAvailable = gymAvailable;
  }
}

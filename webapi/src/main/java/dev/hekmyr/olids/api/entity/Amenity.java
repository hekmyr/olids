package dev.hekmyr.olids.api.entity;

import dev.hekmyr.olids.api.dto.AmenityDTO;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "amenities")
public class Amenity {

  @Id
  @GeneratedValue
  @Column(columnDefinition = "UUID DEFAULT gen_random_uuid()")
  private UUID id;

  @Column(name = "air_conditioning")
  private boolean airConditioningAvailable;

  @Column(name = "terrace")
  private boolean terraceAvailable;

  @Column(name = "garden")
  private boolean gardenAvailable;

  @Column(name = "pool")
  private boolean poolAvailable;

  @Column(name = "hot_tub")
  private boolean hotTubAvailable;

  @Column(name = "ev_charger")
  private boolean evChargerAvailable;

  @Column(name = "indoor_fireplace")
  private boolean indoorFireplaceAvailable;

  @Column(name = "outdoor_fireplace")
  private boolean outdoorFireplaceAvailable;

  @Column(name = "dedicated_workspace")
  private boolean dedicatedWorkspaceAvailable;

  @Column(name = "gym")
  private boolean gymAvailable;

  @Column(name = "date_created")
  private LocalDateTime dateCreated;

  @Column(name = "date_updated")
  private LocalDateTime dateUpdated;

  public Amenity() {}

  public Amenity(AmenityDTO model) {
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
    this.dateCreated = LocalDateTime.now();
    this.dateUpdated = LocalDateTime.now();
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

  public LocalDateTime getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(LocalDateTime dateCreated) {
    this.dateCreated = dateCreated;
  }

  public LocalDateTime getDateUpdated() {
    return dateUpdated;
  }

  public void setDateUpdated(LocalDateTime dateUpdated) {
    this.dateUpdated = dateUpdated;
  }
}

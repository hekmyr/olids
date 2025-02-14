package dev.hekmyr.olids.api.entity;

import dev.hekmyr.olids.api.dto.RentalPropertyDTO;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "rental_properties")
public class RentalProperty implements Serializable {

  @Id
  @GeneratedValue
  @Column(columnDefinition = "UUID DEFAULT gen_random_uuid()")
  private UUID id;

  @Column(name = "accessibility_id")
  private UUID accessibilityId;

  @Column(name = "amenity_id")
  private UUID aminityId;

  @Column
  private String name;

  @Column
  private boolean listed;

  @Column(name = "listed_at")
  private LocalDateTime listedAt;

  @Column(name = "price_per_night")
  private int pricePerNight;

  @Column
  private int beds;

  @Column
  private int bedrooms;

  @Column
  private int bathrooms;

  @Column
  private String street;

  @Column
  private String number;

  @Column(name = "postal_code")
  private String postalCode;

  @Column(name = "date_created")
  private LocalDateTime dateCreated;

  @Column(name = "date_updated")
  private LocalDateTime dateUpdated;

  public RentalProperty() {}

  public RentalProperty(
    RentalPropertyDTO model,
    UUID amenityId,
    UUID accessibilityId
  ) {
    this.aminityId = amenityId;
    this.accessibilityId = accessibilityId;
    this.name = model.getName();
    this.listed = model.isListed();
    this.listedAt = this.listed ? LocalDateTime.now() : null;
    this.pricePerNight = model.getPricePerNight();
    this.beds = model.getBeds();
    this.bedrooms = model.getBedrooms();
    this.bathrooms = model.getBathrooms();
    this.street = model.getStreet();
    this.number = model.getNumber();
    this.postalCode = model.getPostalCode();
    this.dateCreated = LocalDateTime.now();
    this.dateUpdated = LocalDateTime.now();
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public UUID getAccessibilityId() {
    return accessibilityId;
  }

  public void setAccessibilityId(UUID accessibilityId) {
    this.accessibilityId = accessibilityId;
  }

  public UUID getAminityId() {
    return aminityId;
  }

  public void setAminityId(UUID aminityId) {
    this.aminityId = aminityId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isListed() {
    return listed;
  }

  public void setListed(Boolean listed) {
    this.listed = listed;
  }

  public LocalDateTime getListedAt() {
    return listedAt;
  }

  public void setListedAt(LocalDateTime listedAt) {
    this.listedAt = listedAt;
  }

  public Integer getPricePerNight() {
    return pricePerNight;
  }

  public void setPricePerNight(Integer pricePerNight) {
    this.pricePerNight = pricePerNight;
  }

  public Integer getBeds() {
    return beds;
  }

  public void setBeds(Integer beds) {
    this.beds = beds;
  }

  public Integer getBedrooms() {
    return bedrooms;
  }

  public void setBedrooms(Integer bedrooms) {
    this.bedrooms = bedrooms;
  }

  public Integer getBathrooms() {
    return bathrooms;
  }

  public void setBathrooms(Integer bathrooms) {
    this.bathrooms = bathrooms;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
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

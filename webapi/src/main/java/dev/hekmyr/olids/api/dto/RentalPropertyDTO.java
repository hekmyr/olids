package dev.hekmyr.olids.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import dev.hekmyr.olids.api.entity.RentalProperty;
import java.util.UUID;

public class RentalPropertyDTO {

  private UUID id;

  @JsonSerialize
  private AccessibilityDTO accessibility;

  @JsonSerialize
  private AmenityDTO amenity;

  private String name;
  private String description;
  private boolean listed;
  private int pricePerNight;
  private int beds;
  private int bedrooms;
  private int bathrooms;
  private String street;
  private String number;
  private String postalCode;
  private String image;
  private Integer maxGuests;

  public RentalPropertyDTO() {}

  public RentalPropertyDTO(RentalProperty entity) {
    this.id = entity.getId();
    this.name = entity.getName();
    this.description = entity.getDescription();
    this.listed = entity.isListed();
    this.pricePerNight = entity.getPricePerNight();
    this.beds = entity.getBeds();
    this.bedrooms = entity.getBedrooms();
    this.bathrooms = entity.getBathrooms();
    this.street = entity.getStreet();
    this.number = entity.getNumber();
    this.postalCode = entity.getPostalCode();
    this.image = entity.getImage();
    this.maxGuests = entity.getMaxGuests();
    this.amenity = new AmenityDTO(entity.getAmenity());
    this.accessibility = new AccessibilityDTO(entity.getAccessibility());
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public AccessibilityDTO getAccessibility() {
    return accessibility;
  }

  public void setAccessibility(AccessibilityDTO accessibility) {
    this.accessibility = accessibility;
  }

  public AmenityDTO getAmenity() {
    return amenity;
  }

  public void setAmenity(AmenityDTO amenity) {
    this.amenity = amenity;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Boolean isListed() {
    return listed;
  }

  public void setListed(Boolean listed) {
    this.listed = listed;
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

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public int getMaxGuests() {
    return maxGuests;
  }

  public void setMaxGuests(int maxGuests) {
    this.maxGuests = maxGuests;
  }  
}

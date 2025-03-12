package dev.hekmyr.olids.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import dev.hekmyr.olids.api.entity.Accessibility;
import dev.hekmyr.olids.api.entity.Amenity;
import dev.hekmyr.olids.api.entity.RentalProperty;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class RentalPropertyDTO {

  private UUID id;

  @JsonSerialize
  private AccessibilityDTO accessibility;

  @JsonSerialize
  private AmenityDTO amenity;

  private String name;
  private boolean listed;
  private int pricePerNight;
  private int beds;
  private int bedrooms;
  private int bathrooms;
  private String street;
  private String number;
  private String postalCode;

  public RentalPropertyDTO() {}

  public RentalPropertyDTO(
    RentalProperty rentalProperty,
    Amenity amenity,
    Accessibility accessibility
  ) {
    this.name = rentalProperty.getName();
    this.listed = rentalProperty.isListed();
    this.id = rentalProperty.getId();
    this.pricePerNight = rentalProperty.getPricePerNight();
    this.beds = rentalProperty.getBeds();
    this.bedrooms = rentalProperty.getBedrooms();
    this.bathrooms = rentalProperty.getBathrooms();
    this.street = rentalProperty.getStreet();
    this.number = rentalProperty.getNumber();
    this.postalCode = rentalProperty.getPostalCode();
    this.amenity = new AmenityDTO(amenity);
    this.accessibility = new AccessibilityDTO(accessibility);
  }

  public RentalPropertyDTO(RentalProperty rentalProperty) {
    this.name = rentalProperty.getName();
    this.listed = rentalProperty.isListed();
    this.id = rentalProperty.getId();
    this.pricePerNight = rentalProperty.getPricePerNight();
    this.beds = rentalProperty.getBeds();
    this.bedrooms = rentalProperty.getBedrooms();
    this.bathrooms = rentalProperty.getBathrooms();
    this.street = rentalProperty.getStreet();
    this.number = rentalProperty.getNumber();
    this.postalCode = rentalProperty.getPostalCode();
    this.amenity = new AmenityDTO(rentalProperty.getAmenity());
    this.accessibility = new AccessibilityDTO(
      rentalProperty.getAccessibility()
    );
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
}

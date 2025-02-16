package dev.hekmyr.olids.api.dto;

import dev.hekmyr.olids.api.entity.User;
import java.time.LocalDate;
import java.util.UUID;

public class UserDTO {

  private UUID id;
  private String lastName;
  private String firstName;
  private String email;
  private String phoneNumber;
  private String street;
  private String number;
  private String postalCode;
  private LocalDate birthDate;

  public UserDTO() {}

  public UserDTO(User model) {
    this.id = model.getId();
    this.lastName = model.getLastName();
    this.firstName = model.getFirstName();
    this.email = model.getEmail();
    this.phoneNumber = model.getPhoneNumber();
    this.street = model.getStreet();
    this.number = model.getNumber();
    this.postalCode = model.getPostalCode();
    this.birthDate = model.getBirthDate();
  }

  public UserDTO(UUID id, UserUpdateDTO model) {
    this.id = id;
    this.lastName = model.getLastName();
    this.firstName = model.getFirstName();
    this.email = model.getEmail();
    this.phoneNumber = model.getPhoneNumber();
    this.street = model.getStreet();
    this.number = model.getNumber();
    this.postalCode = model.getPostalCode();
    this.birthDate = model.getBirthDate();
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
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
}

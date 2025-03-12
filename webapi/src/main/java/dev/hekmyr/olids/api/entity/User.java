package dev.hekmyr.olids.api.entity;

import dev.hekmyr.olids.api.auth.UserDetailsManagerImpl;
import dev.hekmyr.olids.api.dto.UserCreateDTO;
import dev.hekmyr.olids.api.dto.UserUpdateDTO;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(generator = "UUID")
  private UUID id;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Reservation> reservations = new ArrayList<>();

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "email")
  private String email;

  @Column(name = "password")
  private String password;

  @Column(name = "phone_number")
  private String phoneNumber;

  @Column(name = "street")
  private String street;

  @Column(name = "number")
  private String number;

  @Column(name = "postal_code")
  private String postalCode;

  @Column(name = "birth_date")
  private LocalDate birthDate;

  @Column(name = "date_created")
  private LocalDateTime dateCreated;

  @Column(name = "date_updated")
  private LocalDateTime dateUpdated;

  public User() {}

  public User(UserUpdateDTO model) {
    this.lastName = model.getLastName();
    this.firstName = model.getFirstName();
    this.email = model.getEmail();
    this.phoneNumber = model.getPhoneNumber();
    this.street = model.getStreet();
    this.number = model.getNumber();
    this.postalCode = model.getPostalCode();
    this.birthDate = model.getBirthDate();
    this.dateCreated = LocalDateTime.now();
    this.dateUpdated = LocalDateTime.now();
  }

  public User(UUID id, UserUpdateDTO model) {
    this.id = id;
    this.lastName = model.getLastName();
    this.firstName = model.getFirstName();
    this.email = model.getEmail();
    this.phoneNumber = model.getPhoneNumber();
    this.street = model.getStreet();
    this.number = model.getNumber();
    this.postalCode = model.getPostalCode();
    this.birthDate = model.getBirthDate();
    this.dateUpdated = LocalDateTime.now();
  }

  public User(UserCreateDTO dto) {
    this.email = dto.getEmail();
    this.password = UserDetailsManagerImpl.encoder.encode(dto.getPassword());
    this.dateCreated = LocalDateTime.now();
    this.dateUpdated = LocalDateTime.now();
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

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
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

  public void addReservation(Reservation reservation) {
    reservations.add(reservation);
    reservation.setUser(this);
  }

  public void removeReservation(Reservation reservation) {
    reservations.remove(reservation);
    reservation.setUser(null);
  }

  // Getters and setters
  public List<Reservation> getReservations() {
    return reservations;
  }

  public void setReservations(List<Reservation> reservations) {
    this.reservations = reservations;
  }
}

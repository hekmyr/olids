package dev.hekmyr.olids.api.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "reservations")
public class Reservation {

  @Id
  @GeneratedValue(generator = "UUID")
  private UUID id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private User user;

  @OneToMany(
    mappedBy = "reservation",
    cascade = CascadeType.ALL,
    orphanRemoval = true
  )
  private List<ReservationDetail> details = new ArrayList<>();

  @Column(name = "date_created", nullable = false)
  private LocalDateTime dateCreated;

  @Column(name = "date_updated", nullable = false)
  private LocalDateTime dateUpdated;

  // Add methods for managing the relationship
  public void addDetail(ReservationDetail detail) {
    details.add(detail);
    detail.setReservation(this);
  }

  public void removeDetail(ReservationDetail detail) {
    details.remove(detail);
    detail.setReservation(null);
  }

  // Getters and setters
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public List<ReservationDetail> getDetails() {
    return details;
  }

  public void setDetails(List<ReservationDetail> details) {
    this.details = details;
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

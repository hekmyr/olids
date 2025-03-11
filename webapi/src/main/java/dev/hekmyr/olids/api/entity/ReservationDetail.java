package dev.hekmyr.olids.api.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "reservation_details")
public class ReservationDetail {

  @Id
  @GeneratedValue(generator = "UUID")
  private UUID id;

  private UUID reservationId;

  @Column(name = "price_per_night", nullable = false)
  private float pricePerNight;

  @Column(name = "date_stay_begin", nullable = false)
  private LocalDateTime dateStayStart;

  @Column(name = "date_stay_end", nullable = false)
  private LocalDateTime dateStayEnd;

  @Column(name = "date_created", nullable = false)
  private LocalDateTime dateCreated;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public UUID getReservationId() {
    return reservationId;
  }

  public void setReservationId(UUID reservationId) {
    this.reservationId = reservationId;
  }

  public float getPricePerNight() {
    return pricePerNight;
  }

  public void setPricePerNight(float pricePerNight) {
    this.pricePerNight = pricePerNight;
  }

  public LocalDateTime getDateStayStart() {
    return dateStayStart;
  }

  public void setDateStayStart(LocalDateTime dateStayStart) {
    this.dateStayStart = dateStayStart;
  }

  public LocalDateTime getDateStayEnd() {
    return dateStayEnd;
  }

  public void setDateStayEnd(LocalDateTime dateStayEnd) {
    this.dateStayEnd = dateStayEnd;
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

  @Column(name = "date_updated", nullable = false)
  private LocalDateTime dateUpdated;
}

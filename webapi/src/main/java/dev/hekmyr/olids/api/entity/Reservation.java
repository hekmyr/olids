package dev.hekmyr.olids.api.entity;

import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "reservations")
public class Reservation {

  @Id
  @GeneratedValue(generator = "UUID")
  private UUID id;

  private UUID userId;

  @OneToMany(mappedBy = "reservationId")
  private List<ReservationDetail> reservationDetails;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public UUID getUserId() {
    return userId;
  }

  public void setUserId(UUID userId) {
    this.userId = userId;
  }

  public List<ReservationDetail> getReservationDetails() {
    return reservationDetails;
  }

  public void setReservationDetails(
    List<ReservationDetail> reservationDetails
  ) {
    this.reservationDetails = reservationDetails;
  }
}

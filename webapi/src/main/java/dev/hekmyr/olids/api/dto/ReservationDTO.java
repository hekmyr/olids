package dev.hekmyr.olids.api.dto;

import java.util.List;
import java.util.UUID;

public class ReservationDTO {

  private UUID id;
  private List<ReservationDetailDTO> reservationDetails;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public List<ReservationDetailDTO> getReservationDetails() {
    return reservationDetails;
  }

  public void setReservationDetails(
    List<ReservationDetailDTO> reservationDetails
  ) {
    this.reservationDetails = reservationDetails;
  }
}

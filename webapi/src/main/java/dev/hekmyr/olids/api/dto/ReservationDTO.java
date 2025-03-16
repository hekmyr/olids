package dev.hekmyr.olids.api.dto;

import dev.hekmyr.olids.api.entity.Reservation;
import dev.hekmyr.olids.api.entity.ReservationDetail;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ReservationDTO {

  private UUID id;

  private List<ReservationDetailDTO> details = new ArrayList<>();

  public ReservationDTO(UUID id, List<ReservationDetailDTO> detailDTOs) {
    this.id = id;
    this.details = detailDTOs;
  }

  public ReservationDTO(Reservation reservation) {
    this.id = reservation.getId();
    this.details = new ArrayList<>();
    for (ReservationDetail detail : reservation.getDetails()) {
      this.details.add(new ReservationDetailDTO(detail));
    }
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public List<ReservationDetailDTO> getDetails() {
    return details;
  }

  public void setDetails(List<ReservationDetailDTO> details) {
    this.details = details;
  }
}

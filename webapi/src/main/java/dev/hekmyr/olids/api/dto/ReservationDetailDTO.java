package dev.hekmyr.olids.api.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class ReservationDetailDTO {

  private UUID id;

  private float pricePerNight;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
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

  private LocalDateTime dateStayStart;

  private LocalDateTime dateStayEnd;
}

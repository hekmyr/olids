package dev.hekmyr.olids.api.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class ReservationDTO {

  private UUID id;
  private RentalPropertyDTO property;
  private BillingInformationDTO billingInformationDTO;
  private float pricePerNight;
  private int guests;
  private boolean isCancelled;
  private LocalDateTime dateStayStart;
  private LocalDateTime dateStayEnd;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public RentalPropertyDTO getProperty() {
    return property;
  }

  public void setProperty(RentalPropertyDTO property) {
    this.property = property;
  }

  public BillingInformationDTO getBillingInformationDTO() {
    return billingInformationDTO;
  }

  public void setBillingInformationDTO(
    BillingInformationDTO billingInformationDTO
  ) {
    this.billingInformationDTO = billingInformationDTO;
  }

  public float getPricePerNight() {
    return pricePerNight;
  }

  public void setPricePerNight(float pricePerNight) {
    this.pricePerNight = pricePerNight;
  }

  public int getGuests() {
    return guests;
  }

  public void setGuests(int guests) {
    this.guests = guests;
  }

  public boolean isCancelled() {
    return isCancelled;
  }

  public void setCancelled(boolean isCancelled) {
    this.isCancelled = isCancelled;
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
}

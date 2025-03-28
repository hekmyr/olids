package dev.hekmyr.olids.api.dto;
import dev.hekmyr.olids.api.entity.Reservation;

import java.time.LocalDateTime;
import java.util.UUID;

public class ReservationDTO {

  private UUID id;
  private RentalPropertyDTO property;
  private BillingInformationDTO billingInformationDTO;
  private float pricePerNight;
  private int guests;
  private boolean isPayed;
  private boolean isCancelled;
  private LocalDateTime dateStayStart;
  private LocalDateTime dateStayEnd;
  
  public ReservationDTO() {}

  public ReservationDTO(Reservation entity) {
    this.id = entity.getId();
    this.property = new RentalPropertyDTO(entity.getRentalProperty());
    this.billingInformationDTO = (entity.getBillingInformation() != null)
        ? BillingInformationDTO.fromEntity(entity.getBillingInformation())
        : null;
    this.pricePerNight = entity.getPricePerNight();
    this.guests = entity.getGuests();
    this.isPayed = entity.isPayed();
    this.isCancelled = entity.isCancelled();
    this.dateStayStart = entity.getDateStayStart();
    this.dateStayEnd = entity.getDateStayEnd();
  }

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
  
  public boolean isPayed() {
    return isPayed;
  }

  public void setPayed(boolean isPayed) {
    this.isPayed = isPayed;
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

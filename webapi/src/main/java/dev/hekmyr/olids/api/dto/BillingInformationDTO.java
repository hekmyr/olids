package dev.hekmyr.olids.api.dto;

import dev.hekmyr.olids.api.entity.BillingInformation;
import java.util.UUID;

public class BillingInformationDTO {

  private UUID id;
  private String cardNumber;
  private int monthExpiration;
  private int yearExpiration;
  private boolean isDefault;

  BillingInformationDTO() {}
  
  // Constructor made package-private or private if only factory method is intended
  BillingInformationDTO(BillingInformation entity) {
    this.id = entity.getId();
    this.cardNumber = entity.getCardNumber(); // Consider masking this number
    this.monthExpiration = entity.getMonthExpiration();
    this.yearExpiration = entity.getYearExpiration();
    this.isDefault = entity.isDefault();
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  public int getMonthExpiration() {
    return monthExpiration;
  }

  public void setMonthExpiration(int monthExpiration) {
    this.monthExpiration = monthExpiration;
  }

  public int getYearExpiration() {
    return yearExpiration;
  }

  public void setYearExpiration(int yearExpiration) {
    this.yearExpiration = yearExpiration;
  }

  public boolean isDefault() {
    return isDefault;
  }

  public void setDefault(boolean isDefault) {
    this.isDefault = isDefault;
  }

  public static BillingInformationDTO fromEntity(BillingInformation entity) {
    var dto = new BillingInformationDTO();
    dto.id = entity.getId();
    dto.cardNumber = entity.getCardNumber();
    dto.monthExpiration = entity.getMonthExpiration();
    dto.yearExpiration = entity.getYearExpiration();
    dto.isDefault = entity.isDefault();
    return dto;
  }
}

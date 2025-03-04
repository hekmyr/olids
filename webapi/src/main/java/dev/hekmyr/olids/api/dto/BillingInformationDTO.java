package dev.hekmyr.olids.api.dto;

import dev.hekmyr.olids.api.entity.BillingInformation;
import java.util.UUID;

public class BillingInformationDTO {

  private UUID id;
  private String cardNumber;
  private int monthExpiration;
  private int yearExpiration;

  public BillingInformationDTO(BillingInformation entity) {
    this.id = entity.getId();
    this.cardNumber = entity.getCardNumber();
    this.monthExpiration = entity.getMonthExpiration();
    this.yearExpiration = entity.getYearExpiration();
  }

  public BillingInformationDTO(BillingInformationUpdateDTO dto) {
    this.id = dto.getId();
    this.cardNumber = dto.getCardNumber();
    this.monthExpiration = dto.getMonthExpiration();
    this.yearExpiration = dto.getYearExpiration();
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
}

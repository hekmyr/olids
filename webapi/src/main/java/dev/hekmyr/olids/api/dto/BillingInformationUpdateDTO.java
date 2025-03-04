package dev.hekmyr.olids.api.dto;

import java.util.UUID;

public class BillingInformationUpdateDTO {

  private UUID id;
  private String cardNumber;
  private int monthExpiration;
  private int yearExpiration;

  public String getCardNumber() {
    return cardNumber;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public UUID getId() {
    return id;
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

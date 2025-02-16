package dev.hekmyr.olids.api.dto;

import java.util.UUID;

public class BillingInformationCreateDTO {

  private UUID userId;
  private String cardNumber;
  private int monthExpiration;
  private int yearExpiration;

  public UUID getUserId() {
    return userId;
  }

  public void setUserId(UUID userId) {
    this.userId = userId;
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

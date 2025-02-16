package dev.hekmyr.olids.api.entity;

import dev.hekmyr.olids.api.dto.BillingInformationCreateDTO;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "billing_informations")
public class BillingInformation {

  @Id
  @GeneratedValue
  @Column(columnDefinition = "UUID DEFAULT gen_random_uuid()")
  private UUID id;

  @Column(name = "user_id")
  private UUID userId;

  @Column(name = "card_number")
  private String cardNumber;

  @Column(name = "month_expiration")
  private int monthExpiration;

  @Column(name = "year_expiration")
  private int yearExpiration;

  @Column(name = "date_created")
  private LocalDateTime dateCreated;

  @Column(name = "date_updated")
  private LocalDateTime dateUpdated;

  public BillingInformation(BillingInformationCreateDTO dto) {
    this.userId = dto.getUserId();
    this.cardNumber = dto.getCardNumber();
    this.monthExpiration = dto.getMonthExpiration();
    this.yearExpiration = dto.getYearExpiration();
    this.dateCreated = LocalDateTime.now();
    this.dateUpdated = LocalDateTime.now();
  }

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

  public LocalDateTime getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(LocalDateTime dateCreated) {
    this.dateCreated = dateCreated;
  }

  public LocalDateTime getDateUpdated() {
    return dateUpdated;
  }

  public void setDateUpdated(LocalDateTime dateUpdated) {
    this.dateUpdated = dateUpdated;
  }
}

package dev.hekmyr.olids.api.entity;

import dev.hekmyr.olids.api.dto.BillingInformationCreateDTO;
import dev.hekmyr.olids.api.dto.BillingInformationUpdateDTO;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "billing_informations")
public class BillingInformation {

  @Id
  @GeneratedValue(generator = "UUID")
  private UUID id;

  @ManyToOne(optional = false)
  private User user;

  @Column(name = "card_number", nullable = false)
  private String cardNumber;

  @Column(name = "month_expiration", nullable = false)
  private int monthExpiration;

  @Column(name = "year_expiration", nullable = false)
  private int yearExpiration;

  @Column(name = "is_default", nullable = false)
  private boolean isDefault;

  @Column(name = "date_created", nullable = false)
  private LocalDateTime dateCreated;

  @Column(name = "date_updated", nullable = false)
  private LocalDateTime dateUpdated;

  public BillingInformation() {}

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
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

  public static BillingInformation fromCreateDTO(
    BillingInformationCreateDTO dto,
    User user
  ) {
    var entity = new BillingInformation();
    entity.user = user;
    entity.cardNumber = dto.getCardNumber();
    entity.monthExpiration = dto.getMonthExpiration();
    entity.yearExpiration = dto.getYearExpiration();
    entity.isDefault = false;
    entity.dateCreated = LocalDateTime.now();
    entity.dateUpdated = LocalDateTime.now();
    return entity;
  }

  public static BillingInformation fromUpdateDTO(
    BillingInformationUpdateDTO dto,
    boolean isDefault
  ) {
    var entity = new BillingInformation();
    entity.cardNumber = dto.getCardNumber();
    entity.monthExpiration = dto.getMonthExpiration();
    entity.yearExpiration = dto.getYearExpiration();
    entity.isDefault = isDefault;
    entity.dateCreated = LocalDateTime.now();
    entity.dateUpdated = LocalDateTime.now();
    return entity;
  }
}

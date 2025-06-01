package dev.hekmyr.holidays.api.dto;

import java.util.UUID;

public class BillingInformationUpdateDTO {

    private UUID id;
    private String cardNumber;
    private Integer monthExpiration;
    private Integer yearExpiration;

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

    public Integer getMonthExpiration() {
        return monthExpiration;
    }

    public void setMonthExpiration(Integer monthExpiration) {
        this.monthExpiration = monthExpiration;
    }

    public Integer getYearExpiration() {
        return yearExpiration;
    }

    public void setYearExpiration(Integer yearExpiration) {
        this.yearExpiration = yearExpiration;
    }
}

package dev.hekmyr.holidays.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OdooSaleOrderDTO {
    @JsonProperty("id")
    private int id;

    @JsonProperty("amount_total")
    private float amountTotal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getAmountTotal() {
        return amountTotal;
    }

    public void setAmountTotal(float amountTotal) {
        this.amountTotal = amountTotal;
    }
}

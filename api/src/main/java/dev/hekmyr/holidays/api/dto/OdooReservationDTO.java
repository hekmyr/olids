package dev.hekmyr.holidays.api.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAlias;

public class OdooReservationDTO {
    @JsonProperty("id")
    @JsonAlias("id")
    private int id;

    @JsonProperty("productId")
    @JsonAlias("product_id")
    private List<Object> productId;

    @JsonProperty("name")
    @JsonAlias("name")
    private String name;

    @JsonProperty("priceTotal")
    @JsonAlias("price_total")
    private float priceTotal;

    @JsonProperty("dateStayBegin")
    @JsonAlias("date_stay_begin")
    private String dateStayBegin;

    @JsonProperty("dateStayEnd")
    @JsonAlias("date_stay_end")
    private String dateStayEnd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Object> getProductId() {
        return productId;
    }

    public void setProductId(List<Object> productId) {
        this.productId = productId;
    }

    public String getDateStayBegin() {
        return dateStayBegin;
    }

    public void setDateStayBegin(String dateStayBegin) {
        this.dateStayBegin = dateStayBegin;
    }

    public String getDateStayEnd() {
        return dateStayEnd;
    }

    public void setDateStayEnd(String dateStayEnd) {
        this.dateStayEnd = dateStayEnd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(float priceTotal) {
        this.priceTotal = priceTotal;
    }
}

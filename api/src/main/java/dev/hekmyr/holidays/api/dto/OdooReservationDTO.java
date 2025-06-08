package dev.hekmyr.holidays.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OdooReservationDTO {
    @JsonProperty("id")
    private int id;

    @JsonProperty("product_id")
    private int productId;

    @JsonProperty("date_stay_begin")
    private String dateStayBegin;

    @JsonProperty("date_stay_end")
    private String dateStayEnd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
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
}

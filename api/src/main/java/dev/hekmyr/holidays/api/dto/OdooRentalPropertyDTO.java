package dev.hekmyr.holidays.api.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OdooRentalPropertyDTO {

    private int id;
    private String name;

    @JsonProperty("categ_id")
    private List<Object> categId; // [int, String]

    @JsonProperty("list_price")
    private double listPrice;

    @JsonProperty("base_unit_price")
    private double baseUnitPrice;

    @JsonProperty("is_published")
    private boolean isPublished;

    @JsonProperty("write_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime writeDate;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Object> getCategId() {
        return categId;
    }

    public double getListPrice() {
        return listPrice;
    }

    public double getBaseUnitPrice() {
        return baseUnitPrice;
    }

    public boolean isPublished() {
        return isPublished;
    }

    public LocalDateTime getWriteDate() {
        return writeDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategId(List<Object> categId) {
        this.categId = categId;
    }

    public void setListPrice(double listPrice) {
        this.listPrice = listPrice;
    }

    public void setBaseUnitPrice(double baseUnitPrice) {
        this.baseUnitPrice = baseUnitPrice;
    }

    public void setPublished(boolean published) {
        isPublished = published;
    }

    public void setWriteDate(LocalDateTime writeDate) {
        this.writeDate = writeDate;
    }
}

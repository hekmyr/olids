package dev.hekmyr.holidays.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserUpdateDTO {

    @JsonProperty("name")
    private String name;

    @JsonProperty("phone")
    private String phone;
    
    @JsonProperty("street")
    private String street;

    @JsonProperty("zip")
    private String zip;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

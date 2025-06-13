package dev.hekmyr.holidays.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dev.hekmyr.holidays.api.dto.FalseAsStringDeserializer;

public class OdooUserDTO {

    @JsonProperty("name")
    @JsonDeserialize(using = FalseAsStringDeserializer.class)
    private String name;

    @JsonProperty("email")
    @JsonDeserialize(using = FalseAsStringDeserializer.class)
    private String email;

    @JsonProperty("phone")
    @JsonDeserialize(using = FalseAsStringDeserializer.class)
    private String phone;
    
    @JsonProperty("street")
    @JsonDeserialize(using = FalseAsStringDeserializer.class)
    private String street;

    @JsonProperty("zip")
    @JsonDeserialize(using = FalseAsStringDeserializer.class)
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

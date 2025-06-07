package dev.hekmyr.holidays.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OdooUserDTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty("email")
    private String email;
}

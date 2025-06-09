package dev.hekmyr.holidays.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OdooOrderCreateResponseDTO extends OdooResponseDTO {

    @JsonProperty("result")
    private Number result;

    public Number getResult() {
        return result;
    }

    public void setResult(Number result) {
        this.result = result;
    }
}

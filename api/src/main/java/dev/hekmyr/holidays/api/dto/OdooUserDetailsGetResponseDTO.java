package dev.hekmyr.holidays.api.dto;

import java.util.List;

public class OdooUserDetailsGetResponseDTO extends OdooResponseDTO {

    private List<OdooUserDetails> result;

    public List<OdooUserDetails> getResult() {
        return result;
    }

    public void setResult(List<OdooUserDetails> result) {
        this.result = result;
    }
}

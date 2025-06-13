package dev.hekmyr.holidays.api.dto;

import java.util.List;

public class OdooUserGetResponseDTO extends OdooResponseDTO {

    private List<OdooUserDTO> result;

    public List<OdooUserDTO> getResult() {
        return result;
    }

    public void setResult(List<OdooUserDTO> result) {
        this.result = result;
    }
}

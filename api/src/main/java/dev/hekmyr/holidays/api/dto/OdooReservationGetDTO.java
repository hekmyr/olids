package dev.hekmyr.holidays.api.dto;

import java.util.List;

public class OdooReservationGetDTO extends OdooResponseDTO {

    private List<OdooReservationDTO> result;

    public List<OdooReservationDTO> getResult() {
        return result;
    }

    public void setResult(List<OdooReservationDTO> result) {
        this.result = result;
    }
}

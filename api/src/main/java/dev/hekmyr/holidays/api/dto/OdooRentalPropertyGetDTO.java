package dev.hekmyr.holidays.api.dto;

import java.util.List;

public class OdooRentalPropertyGetDTO extends OdooResponseDTO {

    private List<OdooRentalPropertyDTO> result;

    public List<OdooRentalPropertyDTO> getResult() {
        return result;
    }

    public void setResult(List<OdooRentalPropertyDTO> result) {
        this.result = result;
    }
}

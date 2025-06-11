package dev.hekmyr.holidays.api.dto;

import java.util.List;

public class OdooSaleOrderGetResponseDTO extends OdooResponseDTO {

    private List<OdooSaleOrderDTO> result;

    public List<OdooSaleOrderDTO> getResult() {
        return result;
    }

    public void setResult(List<OdooSaleOrderDTO> result) {
        this.result = result;
    }
}

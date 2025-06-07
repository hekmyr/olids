package dev.hekmyr.holidays.api.dto;

import java.util.List;

public class OdooRentalPropertyGetDTO {

    private String jsonrpc;
    private Integer id;
    private List<OdooRentalPropertyDTO> result;

    public String getJsonrpc() {
        return jsonrpc;
    }

    public void setJsonrpc(String jsonrpc) {
        this.jsonrpc = jsonrpc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<OdooRentalPropertyDTO> getResult() {
        return result;
    }

    public void setResult(List<OdooRentalPropertyDTO> result) {
        this.result = result;
    }
}

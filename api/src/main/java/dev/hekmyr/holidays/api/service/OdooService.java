package dev.hekmyr.holidays.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dev.hekmyr.holidays.api.dto.OdooRequestDTO;
import dev.hekmyr.holidays.api.dto.OdooResponseDTO;
import dev.hekmyr.holidays.api.exception.InternalErrorException;
import dev.hekmyr.holidays.api.model.ErrorCodes;
import dev.hekmyr.holidays.api.repository.RentalPropertyRepository;

@Service
public class OdooService {

    @Value("${ODOO_URL}")
    private String URL;

    @Value("${ODOO_DB}")
    private String DB_NAME;

    @Value("${ODOO_ADMIN_PASSWORD}")
    private String PASSWORD;

    private final String VERSION = "2.0";
    private final RestTemplateBuilder templateBuilder;
    private final RestTemplate restTemplate;

    public OdooService(
        RentalPropertyRepository rentalPropertyRepository,
        RestTemplateBuilder templateBuilder
    ) {
        this.templateBuilder = templateBuilder;
        this.restTemplate = this.templateBuilder.build();
    }

    public <T extends OdooResponseDTO> T find(
        String model_name,
        List<String> fields,
        List<List<String>> conditions,
        Class<T> responseType
    ) throws InternalErrorException {
        var args = List.of(
            DB_NAME,
            2,
            PASSWORD,
            model_name,
            "search_read",
            conditions,
            fields
        );
        OdooRequestDTO.Params params = new OdooRequestDTO.Params("object", "execute", args);
        OdooRequestDTO dto = new OdooRequestDTO(VERSION, "call", params);

        ResponseEntity<T> response = restTemplate.postForEntity(URL, dto, responseType);

        handleError(response);

        return response.getBody();
    }

    public <K, T extends OdooResponseDTO> T update(
        String model_name,
        List<Integer> identifiers,
        K object,
        Class<T> responseType
    ) throws InternalErrorException {
        var args = List.of(
            DB_NAME,
            2,
            PASSWORD,
            model_name,
            "write",
            identifiers,
            object
        );
        OdooRequestDTO.Params params = new OdooRequestDTO.Params("object", "execute", args);
        OdooRequestDTO dto = new OdooRequestDTO(VERSION, "call", params);

        ResponseEntity<T> response = restTemplate.postForEntity(
            URL,
            dto,
            responseType
        );

        handleError(response);

        return response.getBody();
    }

    public <T, K extends OdooResponseDTO> K save(
        String model_name,
        T object,
        Class<K> responseType
    ) throws InternalErrorException {
        var args = List.of(
            DB_NAME,
            2,
            PASSWORD,
            model_name,
            "create",
            object
        );

        var params = new OdooRequestDTO.Params("object", "execute", args);
        var dto = new OdooRequestDTO(VERSION, "call", params);

        ResponseEntity<K> response = restTemplate.postForEntity(
            URL,
            dto,
            responseType
        );

        handleError(response);

        return response.getBody();
    }

    public OdooResponseDTO execute(String model, String method, List<Integer> ids, java.util.Map<String, Object> values) throws InternalErrorException {
        var args = List.of(
            DB_NAME,
            2,
            PASSWORD,
            model,
            method,
            List.of(ids),
            values
        );
        OdooRequestDTO.Params params = new OdooRequestDTO.Params("object", "execute", args);
        OdooRequestDTO dto = new OdooRequestDTO(VERSION, "call", params);
        ResponseEntity<OdooResponseDTO> response = restTemplate.postForEntity(URL, dto, OdooResponseDTO.class);
        handleError(response);
        return response.getBody();
    }

    private <T extends OdooResponseDTO> void handleError(ResponseEntity<T> response) throws InternalErrorException {
        if (response.getStatusCode() != HttpStatus.OK)
            throw new InternalErrorException(ErrorCodes.RESPONSE_NOT_OK, "HTTP status code of odoo response is not OK");
        T odooResponse = response.getBody();
        if (odooResponse.hasError())
            throw new InternalErrorException(
                ErrorCodes.ODOO_ERROR,
                odooResponse
                    .getError()
                    .getData()
                    .getMessage()
            );
    }
}

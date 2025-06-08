package dev.hekmyr.holidays.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.hekmyr.holidays.api.dto.OdooRentalPropertyDTO;
import dev.hekmyr.holidays.api.dto.OdooRentalPropertyGetDTO;
import dev.hekmyr.holidays.api.dto.RentalPropertyRequestDTO;
import dev.hekmyr.holidays.api.exception.InternalErrorException;
import dev.hekmyr.holidays.api.exception.NotFoundException;
import dev.hekmyr.holidays.api.model.ErrorCodes;

@Service
public class RentalPropertyService {

    private final OdooService odooService;
    private final List<String> FIELDS = List.of(
        "id",
        "name",
        "description",
        "beds",
        "bedrooms",
        "bathrooms",
        "street",
        "number",
        "postal_code",
        "max_guests",
        "air_conditioning_available",
        "terrace_available",
        "garden_available",
        "pool_available",
        "hot_tub_available",
        "ev_charger_available",
        "indoor_fireplace_available",
        "outdoor_fireplace_available",
        "dedicated_workspace_available",
        "gym_available",
        "toilet_grab_bar_available",
        "shower_grab_bar_available",
        "step_free_shower_available",
        "shower_bath_chair_available",
        "step_free_bedroom_access_available",
        "wide_bedroom_entrance_available",
        "step_free_access_available"
    );

    public RentalPropertyService(
        OdooService odooService
    ) {
        this.odooService = odooService;
    }

    public OdooRentalPropertyDTO findById(int id) throws NotFoundException, InternalErrorException {
        List<List<String>> conditions = List.of(
            List.of("categ_id", "=", "All / Rental property"),
            List.of("id", "=", String.valueOf(id))
        );
        OdooRentalPropertyGetDTO response = odooService.<OdooRentalPropertyGetDTO>find("product.template", FIELDS, conditions, OdooRentalPropertyGetDTO.class);
        List<OdooRentalPropertyDTO> result = response.getResult();
        if (result.isEmpty()) {
            throw new NotFoundException(ErrorCodes.NOT_FOUND);
        }
        return result.getFirst();
    }

    public List<OdooRentalPropertyDTO> findAvailableDTOs(
        RentalPropertyRequestDTO dto
    ) throws InternalErrorException {
        // if (dto.getStartDate() != null) {
        //     if (dto.getEndDate() != null) {
        //         return rentalPropertyRepository.findAvailableDTOs(
        //             dto.getStartDate().atTime(LocalTime.MIN),
        //             dto.getEndDate().atTime(LocalTime.MIN)
        //         );
        //     } else return rentalPropertyRepository.findAvailableDTOsByStartDate(
        //         dto.getStartDate().atTime(LocalTime.MIN)
        //     );
        // } else return rentalPropertyRepository.findAllDTOs();
        List<List<String>> conditions = List.of(
            List.of("categ_id", "=", "All / Rental property")
        );
        OdooRentalPropertyGetDTO response = odooService.<OdooRentalPropertyGetDTO>find("product.template", FIELDS, conditions, OdooRentalPropertyGetDTO.class);
        return response.getResult();
    }
}

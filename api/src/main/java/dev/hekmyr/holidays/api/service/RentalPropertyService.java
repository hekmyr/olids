package dev.hekmyr.holidays.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.hekmyr.holidays.api.dto.OdooRentalPropertyDTO;
import dev.hekmyr.holidays.api.dto.OdooRentalPropertyGetDTO;
import dev.hekmyr.holidays.api.dto.RentalPropertyRequestDTO;
import dev.hekmyr.holidays.api.exception.InternalErrorException;

@Service
public class RentalPropertyService {

    private final OdooService odooService;

    public RentalPropertyService(
        OdooService odooService
    ) {
        this.odooService = odooService;
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
        List<String> fields = List.of(
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
        List<List<String>> conditions = List.of(
            List.of("categ_id", "=", "All / Rental property")
        );
        OdooRentalPropertyGetDTO response = odooService.<OdooRentalPropertyGetDTO>find("product.template", fields, conditions, OdooRentalPropertyGetDTO.class);
        return response.getResult();
    }
}

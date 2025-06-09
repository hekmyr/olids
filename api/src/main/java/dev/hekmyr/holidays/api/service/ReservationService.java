package dev.hekmyr.holidays.api.service;

import java.time.Duration;
import java.util.List;

import org.springframework.stereotype.Service;

import dev.hekmyr.holidays.api.dto.OdooOrderCreateDTO;
import dev.hekmyr.holidays.api.dto.OdooOrderCreateResponseDTO;
import dev.hekmyr.holidays.api.dto.OdooOrderLineCreateDTO;
import dev.hekmyr.holidays.api.dto.OdooRentalPropertyDTO;
import dev.hekmyr.holidays.api.dto.OdooReservationDTO;
import dev.hekmyr.holidays.api.dto.OdooReservationGetDTO;
import dev.hekmyr.holidays.api.dto.OdooResponseDTO;
import dev.hekmyr.holidays.api.dto.ReservationCreateDTO;
import dev.hekmyr.holidays.api.exception.*;
import dev.hekmyr.holidays.api.exception.InternalErrorException;
import dev.hekmyr.holidays.api.exception.NotFoundException;
import dev.hekmyr.holidays.api.model.ErrorCodes;

@Service
public class ReservationService {

    private static final Duration MINIMUM_STAY_DURATION = Duration.ofDays(1);

    private final OdooService odooService;
    private final RentalPropertyService rentalPropertyService;

    private final String MODEL_NAME = "sale.order.line";
    private final List<String> FIELDS = List.of(
        "id",
        "product_id",
        "date_stay_begin",
        "date_stay_end"
    );

    public ReservationService(
        OdooService odooService,
        RentalPropertyService rentalPropertyService
    ) {
        this.odooService = odooService;
        this.rentalPropertyService = rentalPropertyService;
    }

    public void createReservation(
        int userId,
        ReservationCreateDTO dto
    ) throws BadRequestException, InternalErrorException, NotFoundException {

        OdooRentalPropertyDTO property = rentalPropertyService.findById(dto.getPropertyId());

        if (dto.getGuests() > property.getMaxGuests()) {
            throw new BadRequestException(
                ErrorCodes.TOO_MANY_GUEST,
                "Number of guests exceeds property capacity."
            );
        }

        // TODO: Check for overlapping reservations for the same property (important!)
        // This check will be used after paying aswell so the reservation can be
        // refunded in case of overlap

        if (dto.getDateStayBegin() == null || dto.getDateStayEnd() == null) {
            throw new BadRequestException(
                ErrorCodes.NO_DATE_PROVIDED,
                "Stay start and end dates must be provided."
            );
        }
        if (!dto.getDateStayBegin().isBefore(dto.getDateStayEnd())) {
            throw new BadRequestException(
                ErrorCodes.END_DATE_BEFORE_START,
                "Stay start date must be before stay end date."
            );
        }

        var stayDuration = Duration.between(
            dto.getDateStayBegin(),
            dto.getDateStayEnd()
        );
        if (stayDuration.compareTo(MINIMUM_STAY_DURATION) < 0) {
            throw new BadRequestException(
                ErrorCodes.TOO_SHORT_DURATION,
                "Minimum stay duration is " +
                MINIMUM_STAY_DURATION.toDays() +
                " night(s)."
            );
        }

        OdooOrderCreateDTO orderDTO = new OdooOrderCreateDTO();
        orderDTO.setPartnerId(userId);

        OdooOrderCreateResponseDTO response = odooService.save("sale.order", orderDTO, OdooOrderCreateResponseDTO.class);

        OdooOrderLineCreateDTO orderLineDTO = new OdooOrderLineCreateDTO();
        orderLineDTO.setOrderId(response.getResult().intValue());
        orderLineDTO.setProductId(dto.getPropertyId());
        orderLineDTO.setDateStayEnd(dto.getDateStayEnd());
        orderLineDTO.setDateStayBegin(dto.getDateStayBegin());

        odooService.save("sale.order.line", orderLineDTO, OdooResponseDTO.class);
    }

    public List<OdooReservationDTO> findAllByUserId(int userId) throws InternalErrorException {
        List<List<String>> conditions = List.of();
        OdooReservationGetDTO response = odooService.find(MODEL_NAME, FIELDS, conditions, OdooReservationGetDTO.class);
        return response.getResult();
    }

    // public ReservationDTO findDTOById(UUID id) {
    //     return reservationRepository
    //         .findDTOById(id)
    //         .orElseThrow(() ->
    //             new RuntimeException("Reservation not found with ID: " + id)
    //         );
    // }
}

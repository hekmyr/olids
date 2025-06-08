package dev.hekmyr.holidays.api.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.hekmyr.holidays.api.dto.OdooReservationDTO;
import dev.hekmyr.holidays.api.dto.OdooReservationGetDTO;
import dev.hekmyr.holidays.api.dto.ReservationCreateDTO;
import dev.hekmyr.holidays.api.dto.ReservationDTO;
import dev.hekmyr.holidays.api.entity.Reservation;
import dev.hekmyr.holidays.api.entity.User;
import dev.hekmyr.holidays.api.exception.InternalErrorException;
import dev.hekmyr.holidays.api.repository.RentalPropertyRepository;
import dev.hekmyr.holidays.api.repository.ReservationRepository;
import dev.hekmyr.holidays.api.repository.UserRepository;

@Service
public class ReservationService {

    private static final Duration MINIMUM_STAY_DURATION = Duration.ofDays(1);

    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;
    private final RentalPropertyRepository rentalPropertyRepository;
    private final OdooService odooService;

    private final String MODEL_NAME = "sale.order.line";
    private final List<String> FIELDS = List.of(
        "id",
        "product_id",
        "date_stay_begin",
        "date_stay_end"
    );

    public ReservationService(
        ReservationRepository reservationRepository,
        UserRepository userRepository,
        OdooService odooService,
        RentalPropertyRepository rentalPropertyRepository
    ) {
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
        this.odooService = odooService;
        this.rentalPropertyRepository = rentalPropertyRepository;
    }

    @Transactional
    public Reservation createReservation(
        UUID userId,
        ReservationCreateDTO dto
    ) {
        User user = userRepository
            .findById(userId)
            .orElseThrow(() ->
                new RuntimeException("User not found with ID: " + userId)
            );

        var property = rentalPropertyRepository
            .findById(dto.getPropertyId())
            .orElseThrow(() ->
                new RuntimeException(
                    "Rental property not found with ID: " + dto.getPropertyId()
                )
            );

        if (dto.getGuests() > property.getMaxGuests()) {
            throw new IllegalArgumentException(
                "Number of guests exceeds property capacity."
            );
        }

        // TODO: Check for overlapping reservations for the same property (important!)
        // This check will be used after paying aswell so the reservation can be
        // refunded in case of overlap

        if (dto.getStayStart() == null || dto.getStayEnd() == null) {
            throw new IllegalArgumentException(
                "Stay start and end dates must be provided."
            );
        }
        if (!dto.getStayStart().isBefore(dto.getStayEnd())) {
            throw new IllegalArgumentException(
                "Stay start date must be before stay end date."
            );
        }

        var stayDuration = Duration.between(
            dto.getStayStart(),
            dto.getStayEnd()
        );
        if (stayDuration.compareTo(MINIMUM_STAY_DURATION) < 0) {
            throw new IllegalArgumentException(
                "Minimum stay duration is " +
                MINIMUM_STAY_DURATION.toDays() +
                " night(s)."
            );
        }

        var reservation = new Reservation();
        reservation.setUser(user);
        reservation.setRentalProperty(property);
        reservation.setBillingInformation(null);
        reservation.setPricePerNight(property.getPricePerNight());
        reservation.setGuests(dto.getGuests());
        reservation.setCancelled(false);
        reservation.setPayed(false);
        reservation.setDateStayStart(dto.getStayStart());
        reservation.setDateStayEnd(dto.getStayEnd());
        reservation.setDateCreated(LocalDateTime.now());
        reservation.setDateUpdated(LocalDateTime.now());

        return reservationRepository.save(reservation);
    }

    public List<OdooReservationDTO> findAllByUserId(int userId) throws InternalErrorException {
        List<List<String>> conditions = List.of();
        OdooReservationGetDTO response = odooService.find(MODEL_NAME, FIELDS, conditions, OdooReservationGetDTO.class);
        return response.getResult();
    }

    public ReservationDTO findDTOById(UUID id) {
        return reservationRepository
            .findDTOById(id)
            .orElseThrow(() ->
                new RuntimeException("Reservation not found with ID: " + id)
            );
    }
}

package dev.hekmyr.olids.api.service;

import dev.hekmyr.olids.api.dto.ReservationCreateDTO;
import dev.hekmyr.olids.api.dto.ReservationDTO;
import dev.hekmyr.olids.api.entity.Reservation;
import dev.hekmyr.olids.api.entity.ReservationDetail;
import dev.hekmyr.olids.api.entity.User;
import dev.hekmyr.olids.api.intf.repository.RentalPropertyRepository;
import dev.hekmyr.olids.api.intf.repository.ReservationDetailRepository;
import dev.hekmyr.olids.api.intf.repository.ReservationRepository;
import dev.hekmyr.olids.api.intf.repository.UserRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservationService {

  private final ReservationRepository reservationRepository;
  private final ReservationDetailRepository reservationDetailRepository;
  private final UserRepository userRepository;
  private final RentalPropertyRepository rentalPropertyRepository;

  public ReservationService(
    ReservationRepository reservationRepository,
    ReservationDetailRepository reservationDetailRepository,
    UserRepository userRepository,
    RentalPropertyRepository rentalPropertyRepository
  ) {
    this.reservationRepository = reservationRepository;
    this.reservationDetailRepository = reservationDetailRepository;
    this.userRepository = userRepository;
    this.rentalPropertyRepository = rentalPropertyRepository;
  }

  @Transactional
  public Reservation createReservation(
    UUID userId,
    List<ReservationCreateDTO> dtos
  ) {
    User user = userRepository
      .findById(userId)
      .orElseThrow(() ->
        new RuntimeException("User not found with ID: " + userId)
      );

    var reservation = new Reservation();
    reservation.setUser(user);
    reservation.setDateCreated(LocalDateTime.now());
    reservation.setDateUpdated(LocalDateTime.now());

    reservation = reservationRepository.save(reservation);

    for (var createDTO : dtos) {
      var property = rentalPropertyRepository
        .findById(createDTO.getPropertyId())
        .orElseThrow();

      var detail = new ReservationDetail();
      detail.setReservation(reservation);
      detail.setRentalProperty(property);
      detail.setPricePerNight(property.getPricePerNight());
      detail.setDateStayStart(createDTO.getStayStart());
      detail.setDateStayEnd(createDTO.getStayEnd());
      detail.setDateCreated(LocalDateTime.now());
      detail.setDateUpdated(LocalDateTime.now());

      reservation.addDetail(detail);
    }

    return reservationRepository.save(reservation);
  }

  public List<ReservationDTO> findAllDTOsByUserId(UUID userId) {
    var result = new ArrayList<ReservationDTO>();
    var reservationIds = reservationRepository.findAllIdsByUserId(userId);
    reservationIds.forEach(id -> {
      result.add(
        new ReservationDTO(
          id,
          reservationDetailRepository.findAllDTOsByReservationId(id)
        )
      );
    });
    return result;
  }

  public ReservationDTO findDTOById(UUID id) {
    return reservationRepository
      .findDTOById(id)
      .orElseThrow(() ->
        new RuntimeException("Reservation not found with ID: " + id)
      );
  }
}

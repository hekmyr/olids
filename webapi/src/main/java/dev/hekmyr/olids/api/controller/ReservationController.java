package dev.hekmyr.olids.api.controller;

import dev.hekmyr.olids.api.Constant;
import dev.hekmyr.olids.api.auth.UserDetailsManagerImpl;
import dev.hekmyr.olids.api.dto.ReservationCreateDTO;
import dev.hekmyr.olids.api.dto.ReservationDTO;
import dev.hekmyr.olids.api.intf.repository.RentalPropertyRepository;
import dev.hekmyr.olids.api.service.ReservationService;
import dev.hekmyr.olids.api.service.UserService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constant.API_V1_ENDPOINT + "/reservation")
public class ReservationController {

  private final ReservationService reservationService;
  private final UserService userService;

  ReservationController(
    UserService userService,
    ReservationService reservationService
  ) {
    this.userService = userService;
    this.reservationService = reservationService;
  }

  @PostMapping
  public ResponseEntity<ReservationDTO> createReservation(
    @RequestBody ReservationCreateDTO payload
  ) {
    var userId = userService.getAuthenticatedUserId();
    var reservation = reservationService.createReservation(userId, payload);
    var reservationDTO = reservationService.findDTOById(reservation.getId());
    return ResponseEntity.ok(reservationDTO);
  }
  
  @GetMapping
  public ResponseEntity<List<ReservationDTO>> getReservations() {
    var userId = userService.getAuthenticatedUserId();
    return ResponseEntity.ok(reservationService.findAllDTOsByUserId(userId));
  }
}

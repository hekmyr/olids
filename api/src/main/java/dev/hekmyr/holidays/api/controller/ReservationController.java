package dev.hekmyr.holidays.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.hekmyr.holidays.api.Constant;
import dev.hekmyr.holidays.api.dto.OdooReservationDTO;
import dev.hekmyr.holidays.api.exception.InternalErrorException;
import dev.hekmyr.holidays.api.exception.NotFoundException;
import dev.hekmyr.holidays.api.model.DataResponseModel;
import dev.hekmyr.holidays.api.model.ErrorCodes;
import dev.hekmyr.holidays.api.service.ReservationService;
import dev.hekmyr.holidays.api.service.UserService;

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

    // @PostMapping
    // public ResponseEntity<ReservationDTO> createReservation(
    //     @RequestBody ReservationCreateDTO payload
    // ) {
    //     var userId = userService.getAuthenticatedUserId();
    //     var reservation = reservationService.createReservation(userId, payload);
    //     var reservationDTO = reservationService.findDTOById(
    //         reservation.getId()
    //     );
    //     return ResponseEntity.ok(reservationDTO);
    // }

    @GetMapping("get-all")
    public ResponseEntity<DataResponseModel<List<OdooReservationDTO>>> getReservations() {
        try {
            int userId = userService.getAuthenticatedUserId();
            return ResponseEntity.ok(
                new DataResponseModel<List<OdooReservationDTO>>(reservationService.findAllByUserId(userId))
            );
        } catch (NotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new DataResponseModel<List<OdooReservationDTO>>(
                    "Reservations were not found",
                    e.getCode()
                )
            );
        } catch(InternalErrorException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                new DataResponseModel<List<OdooReservationDTO>>(
                    "An internal error has occured",
                    e.getCode()
                )
            );
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                new DataResponseModel<List<OdooReservationDTO>>(
                    "An internal error has occured",
                    ErrorCodes.UNKNOWN
                )
            );
        }
    }
}

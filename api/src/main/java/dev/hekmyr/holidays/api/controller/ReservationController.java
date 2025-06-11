package dev.hekmyr.holidays.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.stripe.model.checkout.Session;

import dev.hekmyr.holidays.api.Constant;
import dev.hekmyr.holidays.api.dto.*;
import dev.hekmyr.holidays.api.exception.*;
import dev.hekmyr.holidays.api.model.*;
import dev.hekmyr.holidays.api.service.*;

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

    @PostMapping("new")
    public ResponseEntity<DataResponseModel<String>> createReservation(
        @RequestBody ReservationCreateDTO payload
    ) {
        try {
            int userId = userService.getAuthenticatedUserId();
            Session session = reservationService.createReservation(userId, payload);
            return ResponseEntity.ok(new DataResponseModel<String>(session.getId()));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                new DataResponseModel<String>(
                    "An internal error has occured",
                    ErrorCodes.UNKNOWN
                )
            );
        }
    }

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

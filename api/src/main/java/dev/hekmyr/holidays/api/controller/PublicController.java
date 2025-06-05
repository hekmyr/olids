package dev.hekmyr.holidays.api.controller;

import dev.hekmyr.holidays.api.Constant;
import dev.hekmyr.holidays.api.auth.UserDetailsManagerImpl;
import dev.hekmyr.holidays.api.dto.ContactRequestDTO;
import dev.hekmyr.holidays.api.dto.ErrorResponseDTO;
import dev.hekmyr.holidays.api.dto.RentalPropertyDTO;
import dev.hekmyr.holidays.api.dto.RentalPropertyRequestDTO;
import dev.hekmyr.holidays.api.dto.UserCreateDTO;
import dev.hekmyr.holidays.api.model.ErrorCodes;
import dev.hekmyr.holidays.api.model.MessageResponseModel;
import dev.hekmyr.holidays.api.repository.RentalPropertyRepository;
import dev.hekmyr.holidays.api.service.RentalPropertyService;
import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constant.API_V1_ENDPOINT + "/public")
public class PublicController {

    private final UserDetailsManagerImpl userDetailsManagerImpl;
    private final RentalPropertyRepository rentalPropertyRepository;
    private final RentalPropertyService rentalPropertyService;

    PublicController(
        UserDetailsManagerImpl userDetailsManagerImpl,
        RentalPropertyRepository rentalPropertyRepository,
        RentalPropertyService rentalPropertyService
    ) {
        this.userDetailsManagerImpl = userDetailsManagerImpl;
        this.rentalPropertyRepository = rentalPropertyRepository;
        this.rentalPropertyService = rentalPropertyService;
    }

    @GetMapping("/ping")
    public ResponseEntity<MessageResponseModel> ping() {
        return ResponseEntity.ok(new MessageResponseModel("pong"));
    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@RequestBody UserCreateDTO dto) {
        try {
            var responseDTO = userDetailsManagerImpl.createUser(dto);
            return ResponseEntity.ok(responseDTO);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest()
                .body(
                    new ErrorResponseDTO(
                        ErrorCodes.EMAIL_ALREADY_EXISTS.getCode()
                    )
                );
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/rental-property/{id}")
    public ResponseEntity<RentalPropertyDTO> rentalProperty(
        @PathVariable UUID id
    ) {
        var property = rentalPropertyRepository.findDTOById(id).get();
        return ResponseEntity.ok(property);
    }

    @PostMapping("/rental-properties")
    public ResponseEntity<List<RentalPropertyDTO>> rentalProperties(
        @RequestBody RentalPropertyRequestDTO dto
    ) {
        return ResponseEntity.ok(rentalPropertyService.findAvailableDTOs(dto));
    }

    @PostMapping("/contact")
    public ResponseEntity<MessageResponseModel> contact(
        @RequestBody ContactRequestDTO request
    ) {
        return ResponseEntity.ok(new MessageResponseModel("Message sent"));
    }
}

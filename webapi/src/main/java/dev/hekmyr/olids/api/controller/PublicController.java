package dev.hekmyr.olids.api.controller;

import dev.hekmyr.olids.api.Constant;
import dev.hekmyr.olids.api.auth.UserDetailsManagerImpl;
import dev.hekmyr.olids.api.dto.ContactRequestDTO;
import dev.hekmyr.olids.api.dto.RentalPropertyDTO;
import dev.hekmyr.olids.api.dto.RentalPropertyRequestDTO;
import dev.hekmyr.olids.api.dto.UserCreateDTO;
import dev.hekmyr.olids.api.intf.repository.RentalPropertyRepository;
import dev.hekmyr.olids.api.model.MessageResponseModel;
import dev.hekmyr.olids.api.service.RentalPropertyService;
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

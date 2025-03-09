package dev.hekmyr.olids.api.controller;

import dev.hekmyr.olids.api.Constant;
import dev.hekmyr.olids.api.auth.UserDetailsManagerImpl;
import dev.hekmyr.olids.api.dto.UserCreateDTO;
import dev.hekmyr.olids.api.entity.RentalProperty;
import dev.hekmyr.olids.api.model.MessageResponseModel;
import dev.hekmyr.olids.api.service.DbService;
import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constant.API_V1_ENDPOINT + "/public")
public class PublicController {

  private final UserDetailsManagerImpl userDetailsManagerImpl;

  PublicController(UserDetailsManagerImpl userDetailsManagerImpl) {
    this.userDetailsManagerImpl = userDetailsManagerImpl;
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
  public ResponseEntity<RentalProperty> rentalProperty(@PathVariable UUID id) {
    return ResponseEntity.ok(new DbService().findProperty(id));
  }

  @GetMapping("/rental-properties")
  public ResponseEntity<List<RentalProperty>> rentalProperties() {
    return ResponseEntity.ok(new DbService().allProperties());
  }
}

package dev.hekmyr.olids.api;

import dev.hekmyr.olids.api.dto.*;
import dev.hekmyr.olids.api.entity.RentalProperty;
import dev.hekmyr.olids.api.model.MessageResponseModel;
import dev.hekmyr.olids.api.service.DbService;
import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class Controller {

  @GetMapping("/ping")
  public ResponseEntity<MessageResponseModel> ping() {
    return ResponseEntity.ok(new MessageResponseModel("pong"));
  }

  @PostMapping("/rental-property")
  public ResponseEntity<RentalPropertyDTO> rentalProperty(
    @RequestBody RentalPropertyDTO model
  ) {
    return ResponseEntity.ok(new DbService().saveProperty(model));
  }

  @GetMapping("/rental-property/{id}")
  public ResponseEntity<RentalProperty> rentalProperty(@PathVariable UUID id) {
    return ResponseEntity.ok(new DbService().findProperty(id));
  }

  @GetMapping("/rental-properties")
  public ResponseEntity<List<RentalProperty>> rentalProperties() {
    return ResponseEntity.ok(new DbService().allProperties());
  }

  @PostMapping("/sign-up")
  public ResponseEntity<UserDTO> signUp(@RequestBody UserCreateDTO dto) {
    return ResponseEntity.ok(new DbService().createUser(dto));
  }

  @GetMapping("/user/{id}")
  public ResponseEntity<UserDTO> getUser(@PathVariable UUID id) {
    return ResponseEntity.ok(new DbService().findUser(id));
  }

  @PutMapping("/user/{id}")
  public ResponseEntity<UserDTO> updateUser(
    @PathVariable UUID id,
    @RequestBody UserUpdateDTO dto
  ) {
    return ResponseEntity.ok(new DbService().updateUser(id, dto));
  }

  @PostMapping("/user/billing-information")
  public ResponseEntity<BillingInformationDTO> billingInformation(
    @RequestBody BillingInformationCreateDTO dto
  ) {
    return ResponseEntity.ok(new DbService().addBillingInformation(dto));
  }

  @PutMapping("/user/billing-information/{id}")
  public ResponseEntity<BillingInformationDTO> updateBillingInformation(
    @PathVariable UUID id,
    @RequestBody BillingInformationUpdateDTO dto
  ) {
    return ResponseEntity.ok(new DbService().updateBillingInformation(id, dto));
  }

  @GetMapping("/user/billing-information/{id}")
  public ResponseEntity<BillingInformationDTO> getBillingInformation(
    @PathVariable UUID id
  ) {
    return ResponseEntity.ok(new DbService().getBillingInformation(id));
  }
}

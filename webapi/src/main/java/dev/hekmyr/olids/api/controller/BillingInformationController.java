package dev.hekmyr.olids.api.controller;

import dev.hekmyr.olids.api.Constant;
import dev.hekmyr.olids.api.dto.*;
import dev.hekmyr.olids.api.service.BillingInformationService;
import dev.hekmyr.olids.api.service.UserService;

import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constant.API_V1_ENDPOINT + "/billing-information")
public class BillingInformationController {
    
  public final BillingInformationService billingInformationService;
  public final UserService userService;
  
  public BillingInformationController(BillingInformationService billingInformationService, UserService userService) {
      this.billingInformationService = billingInformationService;
      this.userService = userService;
  }

  @PostMapping
  public ResponseEntity<BillingInformationDTO> billingInformation(
    @RequestBody BillingInformationCreateDTO dto
  ) {
    var userId = userService.getAuthenticatedUserId();
    var entity = billingInformationService.addBillingInformation(userId, dto);
    return ResponseEntity.ok(BillingInformationDTO.fromEntity(entity));
  }

  @PutMapping
  public ResponseEntity<BillingInformationDTO> updateBillingInformation(
    @RequestBody BillingInformationUpdateDTO dto
  ) {
    var userId = userService.getAuthenticatedUserId();
    var updatedDto = billingInformationService.updateBillingInformation(userId, dto);
    return ResponseEntity.ok(updatedDto);
  }

  @GetMapping("/{id}")
  public ResponseEntity<BillingInformationDTO> getBillingInformation(
    @PathVariable UUID id
  ) {
    var userId = userService.getAuthenticatedUserId();
    var dto = billingInformationService.getBillingInformationDTO(userId, id);
    return ResponseEntity.ok(dto);
  }

  @GetMapping("/all")
  public ResponseEntity<
    List<BillingInformationDTO>
  > getAllBillingInformations() {
    var userId = userService.getAuthenticatedUserId();
    var collection = billingInformationService.getAllBillingInformation(userId);
    return ResponseEntity.ok(collection);
  }
}

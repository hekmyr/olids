package dev.hekmyr.olids.api.controller;

import dev.hekmyr.olids.api.Constant;
import dev.hekmyr.olids.api.dto.*;
import dev.hekmyr.olids.api.service.BillingInformationService;
import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constant.API_V1_ENDPOINT + "/billing-information")
public class BillingInformationController {

  @PostMapping
  public ResponseEntity<BillingInformationDTO> billingInformation(
    @RequestBody BillingInformationCreateDTO dto
  ) {
    var entity = BillingInformationService.addBillingInformation(dto);
    return ResponseEntity.ok(new BillingInformationDTO(entity));
  }

  @PutMapping
  public ResponseEntity<BillingInformationDTO> updateBillingInformation(
    @RequestBody BillingInformationUpdateDTO dto
  ) {
    var updatedDTO = BillingInformationService.updateBillingInformation(dto);
    return ResponseEntity.ok(updatedDTO);
  }

  @GetMapping("/{id}")
  public ResponseEntity<BillingInformationDTO> getBillingInformation(
    @PathVariable UUID id
  ) {
    var entity = BillingInformationService.getBillingInformation(id);
    return ResponseEntity.ok(new BillingInformationDTO(entity));
  }

  @GetMapping("/all")
  public ResponseEntity<
    List<BillingInformationDTO>
  > getAllBillingInformations() {
    var collection = BillingInformationService.getAllBillingInformation();
    return ResponseEntity.ok(collection);
  }
}

package dev.hekmyr.olids.api.controller;

import dev.hekmyr.olids.api.Constant;
import dev.hekmyr.olids.api.dto.*;
import dev.hekmyr.olids.api.service.DbService;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constant.API_V1_ENDPOINT + "/billing-information")
public class BillingInformationController {

  @PostMapping("/")
  public ResponseEntity<BillingInformationDTO> billingInformation(
    @RequestBody BillingInformationCreateDTO dto
  ) {
    return ResponseEntity.ok(new DbService().addBillingInformation(dto));
  }

  @PutMapping("/{id}")
  public ResponseEntity<BillingInformationDTO> updateBillingInformation(
    @PathVariable UUID id,
    @RequestBody BillingInformationUpdateDTO dto
  ) {
    return ResponseEntity.ok(new DbService().updateBillingInformation(id, dto));
  }

  @GetMapping("/{id}")
  public ResponseEntity<BillingInformationDTO> getBillingInformation(
    @PathVariable UUID id
  ) {
    return ResponseEntity.ok(new DbService().getBillingInformation(id));
  }
}

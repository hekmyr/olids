package dev.hekmyr.olids.api.controller;

import dev.hekmyr.olids.api.Constant;
import dev.hekmyr.olids.api.dto.*;
import dev.hekmyr.olids.api.entity.RentalProperty;
import dev.hekmyr.olids.api.model.MessageResponseModel;
import dev.hekmyr.olids.api.service.DbService;
import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constant.API_V1_ENDPOINT)
public class Controller {

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

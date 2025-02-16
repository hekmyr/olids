package dev.hekmyr.olids.api;

import dev.hekmyr.olids.api.dto.RentalPropertyDTO;
import dev.hekmyr.olids.api.entity.RentalProperty;
import dev.hekmyr.olids.api.model.MessageResponseModel;
import dev.hekmyr.olids.api.service.DbService;
import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

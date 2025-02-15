package dev.hekmyr.olids.api;

import dev.hekmyr.olids.api.dto.RentalPropertyDTO;
import dev.hekmyr.olids.api.model.MessageResponseModel;
import dev.hekmyr.olids.api.service.DbService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
}

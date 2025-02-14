package dev.hekmyr.olids.api;

import dev.hekmyr.olids.api.dto.RentalPropertyDTO;
import dev.hekmyr.olids.api.model.MessageResponseModel;
import dev.hekmyr.olids.api.service.DbService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class Controller {

  @GetMapping("/ping")
  public MessageResponseModel ping() {
    return new MessageResponseModel("pong");
  }

  @PostMapping("/rental-property")
  public RentalPropertyDTO rentalProperty(
    @RequestBody RentalPropertyDTO model
  ) {
    return new DbService().saveProperty(model);
  }
}

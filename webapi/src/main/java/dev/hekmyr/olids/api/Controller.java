package dev.hekmyr.olids.api;

import dev.hekmyr.olids.api.model.MessageResponseModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class Controller {

  @GetMapping("/ping")
  public MessageResponseModel ping() {
    return new MessageResponseModel("pong");
  }
}

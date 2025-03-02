package dev.hekmyr.olids.api.controller;

import dev.hekmyr.olids.api.Constant;
import dev.hekmyr.olids.api.auth.UserDetailsManagerImpl;
import dev.hekmyr.olids.api.dto.UserCreateDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constant.API_V1_ENDPOINT + "/public")
public class PublicController {

  @PostMapping("/sign-up")
  public ResponseEntity<?> signUp(@RequestBody UserCreateDTO dto) {
    try {
      var responseDTO = new UserDetailsManagerImpl().createUser(dto);
      return ResponseEntity.ok(responseDTO);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.internalServerError().build();
    }
  }
}

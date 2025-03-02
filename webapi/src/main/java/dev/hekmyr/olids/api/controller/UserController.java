package dev.hekmyr.olids.api.controller;

import dev.hekmyr.olids.api.Constant;
import dev.hekmyr.olids.api.dto.UserDTO;
import dev.hekmyr.olids.api.dto.UserUpdateDTO;
import dev.hekmyr.olids.api.service.DbService;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constant.API_V1_ENDPOINT + "/user")
public class UserController {

  @GetMapping("/sign-in")
  public ResponseEntity<?> signIn() {
    return ResponseEntity.ok("You are authenticated!\n");
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserDTO> getUser(@PathVariable UUID id) {
    return ResponseEntity.ok(new DbService().findUser(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<UserDTO> updateUser(
    @PathVariable UUID id,
    @RequestBody UserUpdateDTO dto
  ) {
    return ResponseEntity.ok(new DbService().updateUser(id, dto));
  }
}

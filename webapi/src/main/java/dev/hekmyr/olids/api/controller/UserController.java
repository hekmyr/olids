package dev.hekmyr.olids.api.controller;

import dev.hekmyr.olids.api.Constant;
import dev.hekmyr.olids.api.dto.UserDTO;
import dev.hekmyr.olids.api.dto.UserUpdateDTO;
import dev.hekmyr.olids.api.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constant.API_V1_ENDPOINT + "/user")
public class UserController {

  @GetMapping("/sign-in")
  public ResponseEntity<?> signIn() {
    return ResponseEntity.ok("You are authenticated!\n");
  }

  @GetMapping
  public ResponseEntity<UserDTO> getUser() {
    var userDTO = UserService.getAuthenticatedUserDTO();
    return ResponseEntity.ok(userDTO);
  }

  @PutMapping
  public ResponseEntity<UserDTO> updateUser(@RequestBody UserUpdateDTO dto) {
    var username = UserService.getAuthenticatedUsername();
    var userDTO = UserService.updateUser(username, dto);
    return ResponseEntity.ok(userDTO);
  }
}

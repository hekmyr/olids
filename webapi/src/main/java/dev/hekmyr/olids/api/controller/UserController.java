package dev.hekmyr.olids.api.controller;

import dev.hekmyr.olids.api.Constant;
import dev.hekmyr.olids.api.dto.UserDTO;
import dev.hekmyr.olids.api.dto.UserUpdateDTO;
import dev.hekmyr.olids.api.model.MessageResponseModel;
import dev.hekmyr.olids.api.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constant.API_V1_ENDPOINT + "/user")
public class UserController {
    
  public final UserService userService;
  
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/sign-in")
  public ResponseEntity<?> signIn() {
    var auth = UserService.getAuthentication(); 
    if (auth != null && auth.isAuthenticated()) {
      return ResponseEntity.ok(new MessageResponseModel("You are authenticated"));
    } 
    return ResponseEntity.status(401).body(new MessageResponseModel("Authentication required"));
  }

  // @GetMapping
  // public ResponseEntity<UserDTO> getUser() {
  //   var userDTO = UserService.getAuthenticatedUserDTO();
  //   return ResponseEntity.ok(userDTO);
  // }

  // @PutMapping
  // public ResponseEntity<UserDTO> updateUser(@RequestBody UserUpdateDTO dto) {
  //   var username = UserService.getAuthenticatedUsername();
  //   var userDTO = UserService.updateUser(username, dto);
  //   return ResponseEntity.ok(userDTO);
  // }
}

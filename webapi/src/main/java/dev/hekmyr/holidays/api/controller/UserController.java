package dev.hekmyr.holidays.api.controller;

import dev.hekmyr.holidays.api.Constant;
import dev.hekmyr.holidays.api.model.MessageResponseModel;
import dev.hekmyr.holidays.api.service.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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
            return ResponseEntity.ok(
                new MessageResponseModel("You are authenticated")
            );
        }
        return ResponseEntity.status(401).body(
            new MessageResponseModel("Authentication required")
        );
    }

    @GetMapping("/logout")
    public ResponseEntity<MessageResponseModel> logout(
        HttpServletRequest request
    ) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return ResponseEntity.ok(
            new MessageResponseModel("Logged out successfully")
        );
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

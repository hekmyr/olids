package dev.hekmyr.holidays.api.controller;

import dev.hekmyr.holidays.api.Constant;
import dev.hekmyr.holidays.api.dto.OdooUserDTO;
import dev.hekmyr.holidays.api.dto.UserUpdateDTO;
import dev.hekmyr.holidays.api.model.DataResponseModel;
import dev.hekmyr.holidays.api.model.ErrorCodes;
import dev.hekmyr.holidays.api.model.MessageResponseModel;
import dev.hekmyr.holidays.api.service.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constant.API_V1_ENDPOINT + "/user")
public class UserController {

    public final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
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

    @PutMapping("/update")
    public ResponseEntity<MessageResponseModel> updateUser(@RequestBody UserUpdateDTO dto) {
        try {
            int userId = userService.getAuthenticatedUserId();
            userService.update(dto, userId);
            return ResponseEntity.ok(new MessageResponseModel("User informations were updated successfully"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                new MessageResponseModel("An internal error has occured", ErrorCodes.UNKNOWN)
            );
        }
    }

    @GetMapping("get")
    public ResponseEntity<DataResponseModel<OdooUserDTO>> getUser() {
        try {
            String email = userService.getAuthenticatedUsername();
            OdooUserDTO user = userService.findUserByEmail(email);
            return ResponseEntity.ok(new DataResponseModel<>(user));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                new DataResponseModel<>("An internal error has occured", ErrorCodes.UNKNOWN)
            );
        }
    }
}

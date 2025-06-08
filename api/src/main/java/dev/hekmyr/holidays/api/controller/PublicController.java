package dev.hekmyr.holidays.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.hekmyr.holidays.api.Constant;
import dev.hekmyr.holidays.api.auth.AuthenticationProviderImpl;
import dev.hekmyr.holidays.api.auth.UserDetailsManagerImpl;
import dev.hekmyr.holidays.api.dto.ContactRequestDTO;
import dev.hekmyr.holidays.api.dto.OdooRentalPropertyDTO;
import dev.hekmyr.holidays.api.dto.RentalPropertyRequestDTO;
import dev.hekmyr.holidays.api.dto.SignInDTO;
import dev.hekmyr.holidays.api.dto.UserCreateDTO;
import dev.hekmyr.holidays.api.dto.UserDTO;
import dev.hekmyr.holidays.api.exception.BadRequestException;
import dev.hekmyr.holidays.api.exception.InternalErrorException;
import dev.hekmyr.holidays.api.exception.NotFoundException;
import dev.hekmyr.holidays.api.model.DataResponseModel;
import dev.hekmyr.holidays.api.model.ErrorCodes;
import dev.hekmyr.holidays.api.model.MessageResponseModel;
import dev.hekmyr.holidays.api.service.RentalPropertyService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping(Constant.API_V1_ENDPOINT + "/public")
public class PublicController {

    private final UserDetailsManagerImpl userDetailsManagerImpl;
    private final RentalPropertyService rentalPropertyService;
    private final AuthenticationProviderImpl authenticationProviderImpl;

    PublicController(
        UserDetailsManagerImpl userDetailsManagerImpl,
        RentalPropertyService rentalPropertyService,
        AuthenticationProviderImpl authenticationProviderImpl
    ) {
        this.userDetailsManagerImpl = userDetailsManagerImpl;
        this.rentalPropertyService = rentalPropertyService;
        this.authenticationProviderImpl = authenticationProviderImpl;
    }

    @GetMapping("/ping")
    public ResponseEntity<MessageResponseModel> ping() {
        return ResponseEntity.ok(new MessageResponseModel("pong"));
    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@RequestBody UserCreateDTO dto) {
        try {
            var response = userDetailsManagerImpl.createUser(dto);
            return ResponseEntity.ok(new DataResponseModel<UserDTO>(response));
        } catch (BadRequestException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new MessageResponseModel("Bad request", e.getCode())
            );
        } catch(InternalErrorException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                new MessageResponseModel("An internal error has occured", e.getCode())
            );
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                new MessageResponseModel(
                    "An internal error has occured",
                    ErrorCodes.UNKNOWN
                )
            );
        }
    }

    @PostMapping("/sign-in")
    public ResponseEntity<MessageResponseModel> signIn(@RequestBody SignInDTO dto, HttpServletRequest request) {
        try {
            Authentication authenticationToken = new UsernamePasswordAuthenticationToken(
                dto.getEmail(),
                dto.getPassword()
            );
            Authentication authenticatedAuth = authenticationProviderImpl.authenticate(authenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authenticatedAuth);

            // Persist SecurityContext to session
            HttpSession session = request.getSession(true);
            session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());

            return ResponseEntity.ok(
                new MessageResponseModel("Sign-in successful")
            );
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                new MessageResponseModel("Invalid username or password")
            );
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                new MessageResponseModel(
                    "An internal error has occurred",
                    ErrorCodes.UNKNOWN
                )
            );
        }
    }


    @GetMapping("/rental-property/{id}")
    public ResponseEntity<DataResponseModel<OdooRentalPropertyDTO>> rentalProperty(
        @PathVariable int id
    ) {
        try {
            OdooRentalPropertyDTO property = rentalPropertyService.findById(id);
            return ResponseEntity.ok(new DataResponseModel<OdooRentalPropertyDTO>(property));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new DataResponseModel<OdooRentalPropertyDTO>("Rental property was not found", ErrorCodes.NOT_FOUND));
        }  catch(InternalErrorException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                new DataResponseModel<OdooRentalPropertyDTO>("An internal error has occured", e.getCode())
            );
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                new DataResponseModel<OdooRentalPropertyDTO>(
                    "An internal error has occured",
                    ErrorCodes.UNKNOWN
                )
            );
        }
    }

    @PostMapping("/rental-properties")
    public ResponseEntity<DataResponseModel<List<OdooRentalPropertyDTO>>> rentalProperties(
        @RequestBody RentalPropertyRequestDTO dto
    ) {
        try {
            return ResponseEntity.ok(
                new DataResponseModel<List<OdooRentalPropertyDTO>>(rentalPropertyService.findAvailableDTOs(dto))
            );
        } catch(InternalErrorException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                new DataResponseModel<List<OdooRentalPropertyDTO>>()
            );
        }
    }

    @PostMapping("/contact")
    public ResponseEntity<MessageResponseModel> contact(
        @RequestBody ContactRequestDTO request
    ) {
        return ResponseEntity.ok(new MessageResponseModel("Message sent"));
    }
}

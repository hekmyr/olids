package dev.hekmyr.holidays.api.service;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import dev.hekmyr.holidays.api.dto.OdooResponseDTO;
import dev.hekmyr.holidays.api.dto.OdooUserCreateDTO;
import dev.hekmyr.holidays.api.dto.OdooUserDTO;
import dev.hekmyr.holidays.api.dto.OdooUserDetails;
import dev.hekmyr.holidays.api.dto.OdooUserDetailsGetResponseDTO;
import dev.hekmyr.holidays.api.dto.OdooUserGetResponseDTO;
import dev.hekmyr.holidays.api.dto.UserDTO;
import dev.hekmyr.holidays.api.dto.UserUpdateDTO;
import dev.hekmyr.holidays.api.entity.User;
import dev.hekmyr.holidays.api.exception.InternalErrorException;
import dev.hekmyr.holidays.api.exception.NotFoundException;
import dev.hekmyr.holidays.api.model.ErrorCodes;
import dev.hekmyr.holidays.api.repository.UserRepository;

@Service
public class UserService {

    private final String MODEL_NAME = "res.partner";

    private final UserRepository userRepository;
    private final OdooService odooService;

    UserService(UserRepository userRepository, OdooService odooService) {
        this.userRepository = userRepository;
        this.odooService = odooService;
    }

    public User loadUserByUsername(String username) {
        return this.userRepository.findByEmail(username);
    }

    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public String getAuthenticatedUsername() {
        return getAuthentication().getName();
    }

    public User getAuthenticatedUser() {
        return loadUserByUsername(getAuthenticatedUsername());
    }

    public UserDTO getAuthenticatedUserDTO() {
        var entity = loadUserByUsername(getAuthenticatedUsername());
        return UserDTO.fromUserDTO(entity);
    }

    public int getAuthenticatedUserId() throws InternalErrorException, NotFoundException {
        return this.findIdByEmail(getAuthenticatedUsername());
    }

    public int findIdByEmail(String email) throws InternalErrorException, NotFoundException {
        return findByEmail(email).getId();
    }

    public OdooUserDetails findByEmail(String email) throws InternalErrorException, NotFoundException {
        List<List<Object>> conditions = List.of(List.of("email", "=", email));
        List<String> fields = List.of("id", "email", "password");

        OdooUserDetailsGetResponseDTO response = odooService.<OdooUserDetailsGetResponseDTO>find(
            MODEL_NAME,
            fields,
            conditions,
            OdooUserDetailsGetResponseDTO.class
        );
        List<OdooUserDetails> result = response.getResult();

        if (result.isEmpty()) {
            throw new NotFoundException(ErrorCodes.NOT_FOUND, "User not found with email: " + email);
        }

        return result.get(0);
    }

    public OdooUserDTO findUserByEmail(String email) throws InternalErrorException, NotFoundException {
        List<List<Object>> conditions = List.of(List.of("email", "=", email));
        List<String> fields = List.of(
            "id",
            "name",
            "email",
            "phone",
            "street",
            "zip"
        );

        OdooUserGetResponseDTO response = odooService.<OdooUserGetResponseDTO>find(
            MODEL_NAME,
            fields,
            conditions,
            OdooUserGetResponseDTO.class
        );
        List<OdooUserDTO> result = response.getResult();

        if (result.isEmpty()) {
            throw new NotFoundException(ErrorCodes.NOT_FOUND, "User not found with email: " + email);
        }

        return result.get(0);
    }

    public void update(UserUpdateDTO dto, int userId) throws InternalErrorException {
        List<Integer> identifiants = List.of(userId);
        odooService.update(MODEL_NAME, identifiants, dto, OdooResponseDTO.class);
    }

    public void save(OdooUserCreateDTO dto) throws InternalErrorException {
        odooService.save(MODEL_NAME, dto, OdooResponseDTO.class);
    }
}

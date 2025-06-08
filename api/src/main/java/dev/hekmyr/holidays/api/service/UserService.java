package dev.hekmyr.holidays.api.service;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import dev.hekmyr.holidays.api.dto.OdooResponseDTO;
import dev.hekmyr.holidays.api.dto.OdooUserCreateDTO;
import dev.hekmyr.holidays.api.dto.OdooUserDTO;
import dev.hekmyr.holidays.api.dto.OdooUserGetDTO;
import dev.hekmyr.holidays.api.dto.UserDTO;
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
        List<OdooUserDTO> users = findByEmail(email);
        if (users.isEmpty()) {
            throw new NotFoundException(ErrorCodes.NOT_FOUND, "User not found with email: " + email);
        }
        return users.getFirst().getId();
    }

    public List<OdooUserDTO> findByEmail(String email) throws InternalErrorException {
        List<List<String>> conditions = List.of(List.of("email", "=", email));
        List<String> fields = List.of("id", "email", "password");
        OdooUserGetDTO response = odooService.<OdooUserGetDTO>find(
            MODEL_NAME,
            fields,
            conditions,
            OdooUserGetDTO.class
        );
        return response.getResult();
    }

    public void save(OdooUserCreateDTO dto) throws InternalErrorException {
        odooService.save(MODEL_NAME, dto, OdooResponseDTO.class);
    }
}

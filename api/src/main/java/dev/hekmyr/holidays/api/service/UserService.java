package dev.hekmyr.holidays.api.service;

import dev.hekmyr.holidays.api.auth.AuthenticationProviderImpl;
import dev.hekmyr.holidays.api.dto.UserDTO;
import dev.hekmyr.holidays.api.dto.UserUpdateDTO;
import dev.hekmyr.holidays.api.entity.User;
import dev.hekmyr.holidays.api.intf.repository.UserRepository;
import java.time.LocalDateTime;
import java.util.UUID;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    UserService(
        UserRepository userRepository,
        AuthenticationProviderImpl authenticationProviderImpl
    ) {
        this.userRepository = userRepository;
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

    public UUID getAuthenticatedUserId() {
        return userRepository.findIdByEmail(getAuthenticatedUsername());
    }
}

package dev.hekmyr.holidays.api.auth;

import java.util.List;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import dev.hekmyr.holidays.api.dto.OdooUserCreateDTO;
import dev.hekmyr.holidays.api.dto.OdooUserDTO;
import dev.hekmyr.holidays.api.dto.UserCreateDTO;
import dev.hekmyr.holidays.api.dto.UserDTO;
import dev.hekmyr.holidays.api.exception.BadRequestException;
import dev.hekmyr.holidays.api.exception.InternalErrorException;
import dev.hekmyr.holidays.api.model.ErrorCodes;
import dev.hekmyr.holidays.api.service.UserService;

@Service
public class UserDetailsManagerImpl implements UserDetailsManager {

    private Logger log = LoggerFactory.getLogger(UserDetailsManagerImpl.class);

    public static PasswordEncoder encoder = new BCryptPasswordEncoder();

    public final UserService userService;

    public UserDetailsManagerImpl(
        UserService userService
    ) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        var usernameNotFound = new UsernameNotFoundException(
                "User not found with email: " + email);
        try {
            var result = userService.findByEmail(email);
            if (result.size() == 0) {
                throw usernameNotFound;
            }
            return new UserDetailsImpl(result.getFirst());

        } catch (InternalErrorException ex) {
            ex.printStackTrace();
            throw usernameNotFound;
        }
    }

    @Override
    public void createUser(UserDetails user) {
        log.error("Unimplemented method 'createUser'");
        throw new UnsupportedOperationException(
            "Unimplemented method 'createUser'"
        );
    }

    public UserDTO createUser(UserCreateDTO dto) throws InternalErrorException, BadRequestException {
        List<OdooUserDTO> users = userService.findByEmail(dto.getEmail());
        if (users.size() != 0) {
            throw new BadRequestException(
                ErrorCodes.EMAIL_ALREADY_EXISTS
            );
        }

        if (!isValidPassword(dto.getPassword())) {
            throw new BadRequestException(
                ErrorCodes.WEAK_PASSWORD
            );
        }

        var odooDto = new OdooUserCreateDTO(
            dto.getEmail(),
            encoder.encode(dto.getPassword())
        );

        userService.save(odooDto);

        return UserDTO.fromOdooUserDTO(odooDto);
    }

    private boolean isValidPassword(String password) {
        // Password policy:
        // - Minimum 8 characters
        // - At least one uppercase letter
        // - At least one lowercase letter
        // - At least one digit
        // - At least one special character
        Pattern pattern = Pattern.compile(
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$"
        );
        return pattern.matcher(password).matches();
    }

    @Override
    public void updateUser(UserDetails user) {
        log.error("Unimplemented method 'updateUser'");
        throw new UnsupportedOperationException(
            "Unimplemented method 'updateUser'"
        );
    }

    @Override
    public void deleteUser(String username) {
        log.error("Unimplemented method 'deleteUser'");
        throw new UnsupportedOperationException(
            "Unimplemented method 'deleteUser'"
        );
    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {
        log.error("Unimplemented method 'changePassword'");
        throw new UnsupportedOperationException(
            "Unimplemented method 'changePassword'"
        );
    }

    @Override
    public boolean userExists(String email) {
        throw new UnsupportedOperationException(
            "Unimplemented method 'userExists'"
        );
    }
}

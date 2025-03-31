package dev.hekmyr.olids.api.auth;

import dev.hekmyr.olids.api.dto.UserCreateDTO;
import dev.hekmyr.olids.api.dto.UserDTO;
import dev.hekmyr.olids.api.entity.User;
import dev.hekmyr.olids.api.intf.repository.UserRepository;
import dev.hekmyr.olids.api.model.ErrorCodes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import java.util.regex.Pattern;

@Service
public class UserDetailsManagerImpl implements UserDetailsManager {

  private Logger log = LoggerFactory.getLogger(UserDetailsManagerImpl.class);

  public static PasswordEncoder encoder = new BCryptPasswordEncoder();

  public final UserRepository userRepository;

  public UserDetailsManagerImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String email)
    throws UsernameNotFoundException {
    var user = userRepository.findByEmail(email);
    if (user == null) {
      throw new UsernameNotFoundException(
        "User not found with email: " + email
      );
    }
    return new UserDetailsImpl(user);
  }

  @Override
  public void createUser(UserDetails user) {
    log.error("Unimplemented method 'createUser'");
    throw new UnsupportedOperationException(
      "Unimplemented method 'createUser'"
    );
  }

  public UserDTO createUser(UserCreateDTO dto) {
    if (userRepository.findByEmail(dto.getEmail()) != null) {
      throw new IllegalArgumentException(ErrorCodes.EMAIL_ALREADY_EXISTS.getCode());
    }

    if (!isValidPassword(dto.getPassword())) {
        throw new IllegalArgumentException(ErrorCodes.WEAK_PASSWORD.getCode());
    }

    var entity = new User(dto);
    entity.setPassword(encoder.encode(entity.getPassword()));
    return UserDTO.fromUserDTO(userRepository.save(entity));
  }

    private boolean isValidPassword(String password) {
        // Password policy:
        // - Minimum 8 characters
        // - At least one uppercase letter
        // - At least one lowercase letter
        // - At least one digit
        // - At least one special character
        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
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

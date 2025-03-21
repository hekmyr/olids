package dev.hekmyr.olids.api.auth;

import dev.hekmyr.olids.api.dto.UserCreateDTO;
import dev.hekmyr.olids.api.dto.UserDTO;
import dev.hekmyr.olids.api.entity.User;
import dev.hekmyr.olids.api.intf.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

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
    var entity = new User(dto);
    return UserDTO.fromUserDTO(userRepository.save(entity));
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

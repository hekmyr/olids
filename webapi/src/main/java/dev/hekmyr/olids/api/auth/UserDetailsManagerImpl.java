package dev.hekmyr.olids.api.auth;

import dev.hekmyr.olids.api.dto.UserCreateDTO;
import dev.hekmyr.olids.api.dto.UserDTO;
import dev.hekmyr.olids.api.entity.User;
import dev.hekmyr.olids.api.service.DbService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;

public class UserDetailsManagerImpl implements UserDetailsManager {

  private Logger log = LoggerFactory.getLogger(UserDetailsManagerImpl.class);

  public static PasswordEncoder encoder = new BCryptPasswordEncoder();

  public UserDetailsManagerImpl() {}

  @Override
  public UserDetails loadUserByUsername(String email)
    throws UsernameNotFoundException {
    try (var session = DbService.buildSessionFactory().openSession()) {
      var user = session
        .createSelectionQuery("from User where email = :email", User.class)
        .setParameter("email", email)
        .getSingleResultOrNull();
      return new UserDetailsImpl(user);
    } catch (Exception e) {
      log.error("Could not load user by username");
      e.printStackTrace();
      throw e;
    }
  }

  @Override
  public void createUser(UserDetails user) {
    log.error("Unimplemented method 'createUser'");
    throw new UnsupportedOperationException(
      "Unimplemented method 'createUser'"
    );
  }

  public UserDTO createUser(UserCreateDTO dto) throws Exception {
    var session = DbService.buildSessionFactory().openSession();
    var tx = session.getTransaction();
    var entity = new User(dto);
    try {
      tx.begin();
      session.persist(entity);
      tx.commit();
      return new UserDTO(entity);
    } catch (Exception e) {
      tx.rollback();
      var message = "Could not create a new user";
      log.error(message);
      throw new Exception(e);
    } finally {
      session.close();
    }
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

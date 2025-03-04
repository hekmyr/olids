package dev.hekmyr.olids.api.service;

import dev.hekmyr.olids.api.dto.UserDTO;
import dev.hekmyr.olids.api.dto.UserUpdateDTO;
import dev.hekmyr.olids.api.entity.User;
import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserService {

  private static Logger log = LoggerFactory.getLogger(UserService.class);

  public static UserDTO loadUserByUsername(String username) {
    var sessionFactory = DbService.buildSessionFactory();
    try (var session = sessionFactory.openSession()) {
      var entity = session
        .createSelectionQuery("from User where email = :email", User.class)
        .setParameter("email", username)
        .getSingleResultOrNull();
      return new UserDTO(entity);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static Authentication getAuthentication() {
    return SecurityContextHolder.getContext().getAuthentication();
  }

  public static String getAuthenticatedUsername() {
    return getAuthentication().getName();
  }

  public static UserDTO getAuthenticatedUserDTO() {
    return UserService.loadUserByUsername(getAuthenticatedUsername());
  }

  public static UserDTO updateUser(String username, UserUpdateDTO dto) {
    var session = DbService.buildSessionFactory().openSession();
    var tx = session.getTransaction();
    log.info("Im in here!");
    try {
      tx.begin();
      var hql =
        "UPDATE User u SET " +
        "u.lastName = :lastName, " +
        "u.firstName = :firstName, " +
        "u.email = :email, " +
        "u.phoneNumber = :phoneNumber, " +
        "u.street = :street, " +
        "u.number = :number, " +
        "u.postalCode = :postalCode, " +
        "u.birthDate = :birthDate, " +
        "u.dateUpdated = :dateUpdated " +
        "WHERE u.email = :username";
      session
        .createMutationQuery(hql)
        .setParameter("lastName", dto.getLastName())
        .setParameter("firstName", dto.getFirstName())
        .setParameter("email", dto.getEmail())
        .setParameter("phoneNumber", dto.getPhoneNumber())
        .setParameter("street", dto.getStreet())
        .setParameter("number", dto.getNumber())
        .setParameter("postalCode", dto.getPostalCode())
        .setParameter("birthDate", dto.getBirthDate())
        .setParameter("dateUpdated", LocalDateTime.now())
        .setParameter("username", username)
        .executeUpdate();
      tx.commit();
      return new UserDTO(dto);
    } catch (Exception e) {
      tx.rollback();
      e.printStackTrace();
      throw new RuntimeException(e);
    } finally {
      log.info("Im out here!");
      session.close();
    }
  }
}

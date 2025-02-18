package dev.hekmyr.olids.api.service;

import dev.hekmyr.olids.api.dto.*;
import dev.hekmyr.olids.api.entity.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DbService {

  private SessionFactory sessionFactory;

  public DbService() {
    this.sessionFactory = new Configuration()
      .addAnnotatedClass(Accessibility.class)
      .addAnnotatedClass(Amenity.class)
      .addAnnotatedClass(RentalProperty.class)
      .addAnnotatedClass(User.class)
      .addAnnotatedClass(BillingInformation.class)
      .buildSessionFactory();
  }

  public RentalPropertyDTO saveProperty(RentalPropertyDTO model) {
    var session = this.sessionFactory.openSession();
    var tx = session.getTransaction();
    var amenity = new Amenity(model.getAmenity());
    var accessibility = new Accessibility(model.getAccessibility());
    RentalProperty rentalProperty;
    try {
      tx.begin();
      session.persist(amenity);
      session.persist(accessibility);
      rentalProperty = new RentalProperty(
        model,
        amenity.getId(),
        accessibility.getId()
      );
      session.persist(rentalProperty);
      tx.commit();
      return new RentalPropertyDTO(rentalProperty, amenity, accessibility);
    } catch (Exception e) {
      tx.rollback();
      e.printStackTrace();
      return null;
    } finally {
      session.close();
    }
  }

  public RentalProperty findProperty(UUID id) {
    try (var session = this.sessionFactory.openSession()) {
      return session.get(RentalProperty.class, id);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public List<RentalProperty> allProperties() {
    try (var session = this.sessionFactory.openSession()) {
      return session
        .createQuery("from RentalProperty", RentalProperty.class)
        .getResultList();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public UserDTO createUser(UserCreateDTO dto) {
    var session = this.sessionFactory.openSession();
    var tx = session.getTransaction();
    var user = new User(dto);
    try {
      tx.begin();
      session.persist(user);
      tx.commit();
      return new UserDTO(user);
    } catch (Exception e) {
      tx.rollback();
      e.printStackTrace();
      return null;
    } finally {
      session.close();
    }
  }

  public UserDTO updateUser(UUID id, UserUpdateDTO dto) {
    var session = this.sessionFactory.openSession();
    var tx = session.getTransaction();
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
        "WHERE u.id = :id";
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
        .setParameter("id", id)
        .executeUpdate();
      tx.commit();
      return new UserDTO(id, dto);
    } catch (Exception e) {
      tx.rollback();
      e.printStackTrace();
      return null;
    } finally {
      session.close();
    }
  }

  public UserDTO findUser(UUID id) {
    var session = this.sessionFactory.openSession();
    try {
      var user = session.get(User.class, id);
      return new UserDTO(user);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    } finally {
      session.close();
    }
  }

  public BillingInformationDTO addBillingInformation(
    BillingInformationCreateDTO dto
  ) {
    var session = this.sessionFactory.openSession();
    var tx = session.getTransaction();
    var entity = new BillingInformation(dto);
    try {
      tx.begin();
      session.persist(entity);
      tx.commit();
      return new BillingInformationDTO(entity);
    } catch (Exception e) {
      tx.rollback();
      e.printStackTrace();
      return null;
    } finally {
      session.close();
    }
  }

  public BillingInformationDTO updateBillingInformation(
    UUID id,
    BillingInformationUpdateDTO dto
  ) {
    var session = this.sessionFactory.openStatelessSession();
    var tx = session.getTransaction();
    var hql =
      "UPDATE BillingInformation b SET " +
      "b.cardNumber = :cardNumber, " +
      "b.monthExpiration = :monthExpiration, " +
      "b.yearExpiration = :yearExpiration " +
      "WHERE b.id = :id";
    try {
      tx.begin();
      session
        .createMutationQuery(hql)
        .setParameter("cardNumber", dto.getCardNumber())
        .setParameter("monthExpiration", dto.getMonthExpiration())
        .setParameter("yearExpiration", dto.getYearExpiration())
        .setParameter("id", id)
        .executeUpdate();
      tx.commit();
      return new BillingInformationDTO(id, dto);
    } catch (Exception e) {
      tx.rollback();
      e.printStackTrace();
      return null;
    } finally {
      session.close();
    }
  }

  public BillingInformationDTO getBillingInformation(UUID id) {
    var session = this.sessionFactory.openSession();
    var tx = session.getTransaction();
    try {
      tx.begin();
      var entity = session.get(BillingInformation.class, id);
      tx.commit();
      return new BillingInformationDTO(entity);
    } catch (Exception e) {
      tx.rollback();
      e.printStackTrace();
      return null;
    } finally {
      session.close();
    }
  }
}

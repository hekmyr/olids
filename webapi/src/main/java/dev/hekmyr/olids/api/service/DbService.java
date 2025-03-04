package dev.hekmyr.olids.api.service;

import dev.hekmyr.olids.api.dto.*;
import dev.hekmyr.olids.api.entity.*;
import java.util.List;
import java.util.UUID;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DbService {

  private SessionFactory sessionFactory;

  public DbService() {
    this.sessionFactory = buildSessionFactory();
  }

  public static SessionFactory buildSessionFactory() {
    return new Configuration()
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
      rentalProperty = new RentalProperty(model, amenity, accessibility);
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
}

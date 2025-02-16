package dev.hekmyr.olids.api.service;

import dev.hekmyr.olids.api.dto.RentalPropertyDTO;
import dev.hekmyr.olids.api.entity.Accessibility;
import dev.hekmyr.olids.api.entity.Amenity;
import dev.hekmyr.olids.api.entity.RentalProperty;
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
}

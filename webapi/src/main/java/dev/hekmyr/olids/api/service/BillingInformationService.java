package dev.hekmyr.olids.api.service;

import dev.hekmyr.olids.api.dto.*;
import dev.hekmyr.olids.api.entity.BillingInformation;
import java.util.List;
import java.util.UUID;

public class BillingInformationService {

  public static BillingInformation addBillingInformation(
    BillingInformationCreateDTO dto
  ) {
    var user = UserService.getAuthenticatedUser();
    var entity = new BillingInformation(dto, user);
    var session = DbService.buildSessionFactory().openSession();
    var tx = session.getTransaction();
    try {
      tx.begin();
      session.persist(entity);
      tx.commit();
      return entity;
    } catch (Exception e) {
      tx.rollback();
      throw new RuntimeException(e);
    } finally {
      session.close();
    }
  }

  public static BillingInformation getBillingInformation(UUID id) {
    try (var session = DbService.buildSessionFactory().openSession()) {
      var user = UserService.getAuthenticatedUser();
      return session
        .createSelectionQuery(
          "from BillingInformation bi where bi.user = :user and bi.id = :id",
          BillingInformation.class
        )
        .setParameter("user", user)
        .setParameter("id", id)
        .getSingleResultOrNull();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static List<BillingInformationDTO> getAllBillingInformation() {
    try (var session = DbService.buildSessionFactory().openSession()) {
      var user = UserService.getAuthenticatedUser();
      return session
        .createSelectionQuery(
          "select new BillingInformationDTO(bi) " +
          "from BillingInformation bi " +
          "where bi.user = :user",
          BillingInformationDTO.class
        )
        .setParameter("user", user)
        .getResultList();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static BillingInformationDTO updateBillingInformation(
    BillingInformationUpdateDTO dto
  ) {
    var user = UserService.getAuthenticatedUser();
    var session = DbService.buildSessionFactory().openSession();
    var tx = session.getTransaction();
    var hql =
      "UPDATE BillingInformation b SET " +
      "b.cardNumber = :cardNumber, " +
      "b.monthExpiration = :monthExpiration, " +
      "b.yearExpiration = :yearExpiration " +
      "WHERE b.user = :user and b.id = :id";
    try {
      tx.begin();
      session
        .createMutationQuery(hql)
        .setParameter("cardNumber", dto.getCardNumber())
        .setParameter("monthExpiration", dto.getMonthExpiration())
        .setParameter("yearExpiration", dto.getYearExpiration())
        .setParameter("user", user)
        .setParameter("id", dto.getId())
        .executeUpdate();
      tx.commit();
      return new BillingInformationDTO(dto);
    } catch (Exception e) {
      tx.rollback();
      throw new RuntimeException(e);
    } finally {
      session.close();
    }
  }
}

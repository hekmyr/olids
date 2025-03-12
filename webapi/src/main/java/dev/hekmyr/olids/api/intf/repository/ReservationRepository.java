package dev.hekmyr.olids.api.intf.repository;

import dev.hekmyr.olids.api.entity.Reservation;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReservationRepository
  extends JpaRepository<Reservation, UUID> {
  @Query("SELECT r.id from Reservation r WHERE r.user.id = :userId")
  public List<UUID> findAllIdsByUserId(@Param("userId") UUID userId);
}

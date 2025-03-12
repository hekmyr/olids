package dev.hekmyr.olids.api.intf.repository;

import dev.hekmyr.olids.api.dto.ReservationDetailDTO;
import dev.hekmyr.olids.api.entity.ReservationDetail;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReservationDetailRepository
  extends JpaRepository<ReservationDetail, UUID> {
  @Query(
    "SELECT new dev.hekmyr.olids.api.dto.ReservationDetailDTO(rd) FROM ReservationDetail rd WHERE rd.reservation.id = :reservationId"
  )
  public List<ReservationDetailDTO> findAllDTOsByReservationId(
    @Param("reservationId") UUID reservationId
  );
}

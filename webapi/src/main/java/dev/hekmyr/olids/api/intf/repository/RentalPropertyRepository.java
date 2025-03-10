package dev.hekmyr.olids.api.intf.repository;

import dev.hekmyr.olids.api.dto.RentalPropertyDTO;
import dev.hekmyr.olids.api.entity.RentalProperty;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RentalPropertyRepository
  extends JpaRepository<RentalProperty, UUID> {
  @Query(
    "SELECT new dev.hekmyr.olids.api.dto.RentalPropertyDTO(rp) FROM RentalProperty rp WHERE rp.id = :id"
  )
  Optional<RentalPropertyDTO> findDTOById(@Param("id") UUID id);

  @Query(
    "SELECT new dev.hekmyr.olids.api.dto.RentalPropertyDTO(rp) FROM RentalProperty rp"
  )
  List<RentalPropertyDTO> findAllDTOs();
}

package dev.hekmyr.holidays.api.repository;

import dev.hekmyr.holidays.api.dto.RentalPropertyDTO;
import dev.hekmyr.holidays.api.entity.RentalProperty;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RentalPropertyRepository
    extends JpaRepository<RentalProperty, UUID> {
    @Query(
        "SELECT NEW dev.hekmyr.holidays.api.dto.RentalPropertyDTO(rp) FROM RentalProperty rp WHERE rp.id = :id"
    )
    Optional<RentalPropertyDTO> findDTOById(@Param("id") UUID id);

    @Query(
        "SELECT NEW dev.hekmyr.holidays.api.dto.RentalPropertyDTO(rp) " +
        "FROM RentalProperty rp " +
        "WHERE rp.id " +
        "NOT IN " +
        "(SELECT r.rentalProperty.id FROM Reservation r " +
        "WHERE ((r.dateStayStart <= :startDate) AND (r.dateStayEnd >= :startDate)) " +
        "OR ((r.dateStayStart <= :endDate) AND (r.dateStayEnd >= :endDate)))"
    )
    List<RentalPropertyDTO> findAvailableDTOs(
        @Param("startDate") LocalDateTime startDate,
        @Param("endDate") LocalDateTime endDate
    );

    @Query(
        "SELECT NEW dev.hekmyr.holidays.api.dto.RentalPropertyDTO(rp) " +
        "FROM RentalProperty rp " +
        "WHERE rp.id " +
        "NOT IN " +
        "(SELECT r.rentalProperty.id FROM Reservation r " +
        "WHERE (r.dateStayStart <= :startDate) AND (r.dateStayEnd >= :startDate))"
    )
    List<RentalPropertyDTO> findAvailableDTOsByStartDate(
        @Param("startDate") LocalDateTime startDate
    );

    @Query(
        "SELECT NEW dev.hekmyr.holidays.api.dto.RentalPropertyDTO(rp) FROM RentalProperty rp"
    )
    List<RentalPropertyDTO> findAllDTOs();

    @Query(
        "SELECT NEW dev.hekmyr.holidays.api.dto.RentalPropertyDTO(rp) FROM RentalProperty rp ORDER BY rp.dateUpdated DESC LIMIT 1"
    )
    RentalPropertyDTO findLastUpdated();
}

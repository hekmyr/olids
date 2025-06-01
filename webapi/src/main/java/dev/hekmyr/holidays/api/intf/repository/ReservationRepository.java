package dev.hekmyr.holidays.api.intf.repository;

import dev.hekmyr.holidays.api.dto.ReservationDTO;
import dev.hekmyr.holidays.api.entity.Reservation;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReservationRepository
    extends JpaRepository<Reservation, UUID> {
    @Query(
        "SELECT new dev.hekmyr.holidays.api.dto.ReservationDTO(r) FROM Reservation r " +
        "LEFT JOIN FETCH r.rentalProperty rp " +
        "LEFT JOIN FETCH rp.amenity " + // This could be optimised if not always required
        "LEFT JOIN FETCH rp.accessibility " + // This could be optimised if not always required
        "LEFT JOIN FETCH r.billingInformation bi " +
        "WHERE r.user.id = :userId"
    )
    public List<ReservationDTO> findAllDTOsByUserId(
        @Param("userId") UUID userId
    );

    @Query(
        "SELECT new dev.hekmyr.holidays.api.dto.ReservationDTO(r) FROM Reservation r " +
        "LEFT JOIN FETCH r.rentalProperty rp " +
        "LEFT JOIN FETCH rp.amenity " +
        "LEFT JOIN FETCH rp.accessibility " +
        "LEFT JOIN FETCH r.billingInformation bi " +
        "WHERE r.id = :id"
    )
    public Optional<ReservationDTO> findDTOById(@Param("id") UUID id);
}

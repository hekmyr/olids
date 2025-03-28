package dev.hekmyr.olids.api.intf.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

import dev.hekmyr.olids.api.dto.BillingInformationDTO;
import dev.hekmyr.olids.api.entity.BillingInformation;

public interface BillingInformationRepository extends JpaRepository<BillingInformation, UUID> {
  @Query(
    "SELECT NEW dev.hekmyr.olids.api.dto.BillingInformationDTO(bi) "
    + "FROM BillingInformation bi"
  )
  public List<BillingInformationDTO> findAllDTOsByUserId(UUID userId);
  @Query(
    "SELECT NEW dev.hekmyr.olids.api.dto.BillingInformationDTO(bi) "
    + "FROM BillingInformation bi WHERE bi.id = :id AND bi.user.id = :userId"
  )
  public Optional<BillingInformationDTO> findDTOByIdAndUserId(@Param("id") UUID id, @Param("userId") UUID userId);
  @Query("SELECT bi FROM BillingInformation bi WHERE bi.id = :id AND bi.user.id = :userId")
  Optional<BillingInformation> findByIdAndUserId(@Param("id") UUID id, @Param("userId") UUID userId);
}
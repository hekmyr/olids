package dev.hekmyr.olids.api.service;

import dev.hekmyr.olids.api.dto.RentalPropertyDTO;
import dev.hekmyr.olids.api.dto.RentalPropertyRequestDTO;
import dev.hekmyr.olids.api.intf.repository.RentalPropertyRepository;
import java.time.LocalTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class RentalPropertyService {

  private final RentalPropertyRepository rentalPropertyRepository;

  public RentalPropertyService(
    RentalPropertyRepository rentalPropertyRepository
  ) {
    this.rentalPropertyRepository = rentalPropertyRepository;
  }

  public List<RentalPropertyDTO> findAvailableDTOs(
    RentalPropertyRequestDTO dto
  ) {
    if (dto.getStartDate() != null) {
      if (dto.getEndDate() != null) {
        return rentalPropertyRepository.findAvailableDTOs(
          dto.getStartDate().atTime(LocalTime.MIN),
          dto.getEndDate().atTime(LocalTime.MIN)
        );
      } else return rentalPropertyRepository.findAvailableDTOsByStartDate(
        dto.getStartDate().atTime(LocalTime.MIN)
      );
    } else return rentalPropertyRepository.findAllDTOs();
  }
}

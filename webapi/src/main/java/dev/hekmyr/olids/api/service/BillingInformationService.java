package dev.hekmyr.olids.api.service;

import dev.hekmyr.olids.api.dto.*;
import dev.hekmyr.olids.api.entity.BillingInformation;
import dev.hekmyr.olids.api.intf.repository.UserRepository;
import dev.hekmyr.olids.api.intf.repository.BillingInformationRepository;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class BillingInformationService {
  private final BillingInformationRepository billingInformationRepository;
  private final UserRepository userRepository;
    
  public BillingInformationService(BillingInformationRepository billingInformationRepository, UserRepository userRepository) {
      this.billingInformationRepository = billingInformationRepository;
      this.userRepository = userRepository;
  }

  public BillingInformation addBillingInformation(
    UUID userId,
    BillingInformationCreateDTO dto
  ) {
    var user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
    var entity = BillingInformation.fromCreateDTO(dto, user);
    return this.billingInformationRepository.save(entity);
  }

  public BillingInformation getBillingInformation(UUID id) {
      return this.billingInformationRepository
        .findById(id)
        .orElseThrow(() -> new RuntimeException("Billing information not found with ID: " + id));
  }
  public BillingInformationDTO getBillingInformationDTO(UUID userId, UUID id) {
    return this.billingInformationRepository
      .findDTOByIdAndUserId(id, userId)
      .orElseThrow(() -> new RuntimeException("Billing information not found with ID: " + id + " for user " + userId));
  }
  
  public List<BillingInformationDTO> getAllBillingInformation(UUID userId) {
      return this.billingInformationRepository
        .findAllDTOsByUserId(userId);
  }

  public BillingInformationDTO updateBillingInformation(UUID userId, BillingInformationUpdateDTO dto) {
    BillingInformation entity = billingInformationRepository.findByIdAndUserId(dto.getId(), userId)
        .orElseThrow(() -> new RuntimeException("Billing information not found with ID: " + dto.getId() + " for user " + userId));
    
    entity.setCardNumber(dto.getCardNumber());
    entity.setMonthExpiration(dto.getMonthExpiration());
    entity.setYearExpiration(dto.getYearExpiration());
    entity.setDateUpdated(java.time.LocalDateTime.now());
     
    BillingInformation updatedEntity = this.billingInformationRepository.save(entity);
    return BillingInformationDTO.fromEntity(updatedEntity);
  }
}

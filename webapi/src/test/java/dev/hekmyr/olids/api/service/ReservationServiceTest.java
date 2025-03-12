package dev.hekmyr.olids.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import dev.hekmyr.olids.api.dto.ReservationCreateDTO;
import dev.hekmyr.olids.api.entity.*;
import dev.hekmyr.olids.api.intf.repository.*;
import java.time.LocalDateTime;
import java.util.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ReservationServiceTest {

  @Mock
  private ReservationRepository reservationRepository;

  @Mock
  private ReservationDetailRepository reservationDetailRepository;

  @Mock
  private UserRepository userRepository;

  @Mock
  private RentalPropertyRepository rentalPropertyRepository;

  @InjectMocks
  private ReservationService reservationService;

  @Test
  public void testCreateReservation_Success() {
    UUID userId = UUID.randomUUID();
    UUID propertyId = UUID.randomUUID();

    var user = new User();
    user.setId(userId);

    var property = new RentalProperty();
    property.setId(propertyId);

    var savedReservation = new Reservation();
    savedReservation.setId(UUID.randomUUID());
    savedReservation.setUser(user);

    List<ReservationCreateDTO> dtos = List.of(
      new ReservationCreateDTO(
        propertyId,
        999.99f,
        LocalDateTime.now(),
        LocalDateTime.now().plusDays(3)
      )
    );

    when(userRepository.findById(userId)).thenReturn(Optional.of(user));
    when(rentalPropertyRepository.findById(propertyId)).thenReturn(
      Optional.of(property)
    );
    when(reservationRepository.save(any(Reservation.class))).thenReturn(
      savedReservation
    );

    var result = reservationService.createReservation(userId, dtos);

    assertNotNull(result);
    assertEquals(userId, result.getUser().getId());
  }
}

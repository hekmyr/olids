package dev.hekmyr.olids.api.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import dev.hekmyr.olids.api.auth.UserDetailsManagerImpl;
import dev.hekmyr.olids.api.dto.RentalPropertyDTO;
import dev.hekmyr.olids.api.dto.RentalPropertyRequestDTO;
import dev.hekmyr.olids.api.dto.UserCreateDTO;
import dev.hekmyr.olids.api.dto.UserDTO;
import dev.hekmyr.olids.api.entity.Accessibility;
import dev.hekmyr.olids.api.entity.Amenity;
import dev.hekmyr.olids.api.entity.RentalProperty;
import dev.hekmyr.olids.api.intf.repository.AccessibilityRepository;
import dev.hekmyr.olids.api.intf.repository.AmenityRepository;
import dev.hekmyr.olids.api.intf.repository.RentalPropertyRepository;
import dev.hekmyr.olids.api.model.MessageResponseModel;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class PublicControllerTests {

  @Autowired
  private PublicController publicController;

  @Autowired
  private UserDetailsManagerImpl userDetailsManagerImpl;

  @Autowired
  private RentalPropertyRepository rentalPropertyRepository;

  @Autowired
  private AmenityRepository amenityRepository;

  @Autowired
  private AccessibilityRepository accessibilityRepository;

  @Test
  public void testPing_Success() {
    var response = publicController.ping();
    assertEquals(200, response.getStatusCode().value());
    assertResponse(new MessageResponseModel("pong"), response.getBody());
  }

  public void assertResponse(
    MessageResponseModel expected,
    MessageResponseModel actual
  ) {
    assertEquals(expected.getMessage(), actual.getMessage());
  }

  @Test
  public void testSignUp_Success() {
    var email = "john.doe@example.com";
    var password = "pswd";
    var dto = new UserCreateDTO();
    dto.setEmail(email);
    dto.setPassword(password);
    var response = publicController.signUp(dto);
    assertEquals(200, response.getStatusCode().value());
    var expected = new UserDTO();
    expected.setEmail(email);
    assertUser(expected, (UserDTO) response.getBody());
    var userDetails = userDetailsManagerImpl.loadUserByUsername(email);
    assertPassword(password, userDetails.getPassword());
  }

  void assertUser(UserDTO expected, UserDTO actual) {
    assertEquals(expected.getLastName(), actual.getLastName());
    assertEquals(expected.getFirstName(), actual.getFirstName());
    assertEquals(expected.getEmail(), actual.getEmail());
    assertEquals(expected.getPhoneNumber(), actual.getPhoneNumber());
    assertEquals(expected.getStreet(), actual.getStreet());
    assertEquals(expected.getNumber(), actual.getNumber());
    assertEquals(expected.getPostalCode(), actual.getPostalCode());
    assertEquals(expected.getBirthDate(), actual.getBirthDate());
  }

  void assertPassword(String raw, String encoded) {
    assertTrue(UserDetailsManagerImpl.encoder.matches(raw, encoded));
  }

  @Test
  void testRentalProperties_Success() {
    addNewRentalProperty();
    var requestDTO = new RentalPropertyRequestDTO();
    var rentalPropertiesDTOs = publicController
      .rentalProperties(requestDTO)
      .getBody();
    assertEquals(1, rentalPropertiesDTOs.size());

    addNewRentalProperty();
    rentalPropertiesDTOs = publicController
      .rentalProperties(requestDTO)
      .getBody();
    assertEquals(2, rentalPropertiesDTOs.size());

    addNewRentalProperty();
    rentalPropertiesDTOs = publicController
      .rentalProperties(requestDTO)
      .getBody();
    assertEquals(3, rentalPropertiesDTOs.size());
  }

  @Test
  void testRentalProperty_Success() {
    var expectedProperty = addNewRentalProperty();
    var actualProperty = publicController
      .rentalProperty(expectedProperty.getId())
      .getBody();
    assertRentalPropertyDTO(
      new RentalPropertyDTO(expectedProperty),
      actualProperty
    );
  }

  void assertRentalPropertyDTO(
    RentalPropertyDTO expected,
    RentalPropertyDTO actual
  ) {
    assertEquals(expected.getId(), actual.getId());
    assertEquals(expected.getName(), actual.getName());
    assertEquals(expected.isListed(), actual.isListed());
    // assertEquals(expected.getListedAt(), actual.getListedAt());
    assertEquals(expected.getPricePerNight(), actual.getPricePerNight());
    assertEquals(expected.getBeds(), actual.getBeds());
    assertEquals(expected.getBedrooms(), actual.getBedrooms());
    assertEquals(expected.getBathrooms(), actual.getBathrooms());
    assertEquals(expected.getStreet(), actual.getStreet());
    assertEquals(expected.getNumber(), actual.getNumber());
    assertEquals(expected.getPostalCode(), actual.getPostalCode());
    // assertEquals(expected.getDateCreated(), actual.getDateCreated());
    // assertEquals(expected.getDateUpdated(), actual.getDateUpdated());
  }

  RentalProperty addNewRentalProperty() {
    var amenity = new Amenity();
    amenity.setDateCreated(LocalDateTime.now());
    amenity.setDateUpdated(LocalDateTime.now());

    var accessibility = new Accessibility();
    accessibility.setDateCreated(LocalDateTime.now());
    accessibility.setDateUpdated(LocalDateTime.now());

    var property = new RentalProperty();
    property.setAmenity(amenityRepository.save(amenity));
    property.setAccessibility(accessibilityRepository.save(accessibility));
    property.setName("Average house");
    property.setListed(true);
    property.setListedAt(LocalDateTime.now());
    property.setPricePerNight(100);
    property.setBeds(2);
    property.setBedrooms(1);
    property.setBathrooms(1);
    property.setStreet("Example Street");
    property.setNumber("123");
    property.setPostalCode("12345");
    property.setDateCreated(LocalDateTime.now());
    property.setDateUpdated(LocalDateTime.now());

    return rentalPropertyRepository.save(property);
  }
}

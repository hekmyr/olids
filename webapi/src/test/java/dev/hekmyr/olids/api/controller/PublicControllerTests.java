package dev.hekmyr.olids.api.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import dev.hekmyr.olids.api.auth.UserDetailsManagerImpl;
import dev.hekmyr.olids.api.dto.UserCreateDTO;
import dev.hekmyr.olids.api.dto.UserDTO;
import dev.hekmyr.olids.api.model.MessageResponseModel;
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
}

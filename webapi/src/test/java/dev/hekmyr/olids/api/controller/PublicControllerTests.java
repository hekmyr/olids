package dev.hekmyr.olids.api.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import dev.hekmyr.olids.api.model.MessageResponseModel;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PublicControllerTests {

  private final PublicController publicController = new PublicController();

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
}

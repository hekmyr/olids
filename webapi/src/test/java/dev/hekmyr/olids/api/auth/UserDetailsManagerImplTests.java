package dev.hekmyr.olids.api.auth;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import dev.hekmyr.olids.api.dto.UserCreateDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UserDetailsManagerImplTests {

  @Autowired
  private UserDetailsManagerImpl userDetailsManagerImpl;

  @Test
  public void testCreateUser_Success() throws Exception {
    var dto = new UserCreateDTO();
    dto.setEmail("john.doe@example.com");
    dto.setPassword("pswd");
    this.userDetailsManagerImpl.createUser(dto);
    var userDetails =
      this.userDetailsManagerImpl.loadUserByUsername(dto.getEmail());
    assertEquals(dto.getEmail(), userDetails.getUsername());
    assertTrue(
      new BCryptPasswordEncoder()
        .matches(dto.getPassword(), userDetails.getPassword())
    );
  }
}

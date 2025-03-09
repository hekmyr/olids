package dev.hekmyr.olids.api.auth;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;

import dev.hekmyr.olids.api.dto.UserCreateDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class AuthenticationProviderImplTests {

  @Autowired
  private AuthenticationProviderImpl authenticationProviderImpl;

  @Autowired
  private UserDetailsManagerImpl userDetailsManagerImpl;

  @Test
  void testAuthenticate_Sucess() throws Exception {
    var email = "john.doe@example.com";
    var password = "pswd";
    var dto = new UserCreateDTO();
    dto.setEmail(email);
    dto.setPassword(password);
    this.userDetailsManagerImpl.createUser(dto);
    var auth = authenticationProviderImpl.authenticate(
      new UsernamePasswordAuthenticationToken(email, password)
    );
    assertEquals(email, auth.getName());
    assertTrue(
      UserDetailsManagerImpl.encoder.matches(
        password,
        auth.getCredentials().toString()
      )
    );
  }

  @Test
  void testAuthenticate_WrongEmail() throws Exception {
    var email = "john.doe@example.com";
    var password = "pswd";
    var dto = new UserCreateDTO();
    dto.setEmail(email);
    dto.setPassword(password);
    this.userDetailsManagerImpl.createUser(dto);
    assertThrowsExactly(
      BadCredentialsException.class,
      () ->
        authenticationProviderImpl.authenticate(
          new UsernamePasswordAuthenticationToken("wrong.email@example.com", password)
        ),
      "Invalid username or password"
    );
  }

  @Test
  void testAuthenticate_WrongPassword() throws Exception {
    var email = "john.doe@example.com";
    var password = "pswd";
    var dto = new UserCreateDTO();
    dto.setEmail(email);
    dto.setPassword(password);
    this.userDetailsManagerImpl.createUser(dto);
    assertThrowsExactly(
      BadCredentialsException.class,
      () ->
        authenticationProviderImpl.authenticate(
          new UsernamePasswordAuthenticationToken(email, "wrongpassword")
        ),
      "Invalid username or password"
    );
  }
}

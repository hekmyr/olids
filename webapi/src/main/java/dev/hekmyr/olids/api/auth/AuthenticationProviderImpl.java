package dev.hekmyr.olids.api.auth;

import java.util.Arrays;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationProviderImpl implements AuthenticationProvider {

  private final UserDetailsManagerImpl userDetailsManagerImpl;

  AuthenticationProviderImpl(UserDetailsManagerImpl userDetailsManagerImpl) {
    this.userDetailsManagerImpl = userDetailsManagerImpl;
  }

  @Override
  public Authentication authenticate(Authentication authentication)
    throws AuthenticationException {
    var username = authentication.getName();
    var rawPassword = authentication.getCredentials();
    var userDetails = userDetailsManagerImpl.loadUserByUsername(username);
    var encodedPassword = userDetails.getPassword();
    System.out.println();
    if (
      userDetails.getUsername().equals(username) &&
      UserDetailsManagerImpl.encoder.matches(
        rawPassword.toString(),
        encodedPassword
      )
    ) {
      return new UsernamePasswordAuthenticationToken(
        username,
        encodedPassword,
        Arrays.asList()
      );
    } else throw new AuthenticationCredentialsNotFoundException("Error!");
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return UsernamePasswordAuthenticationToken.class.isAssignableFrom(
        authentication
      );
  }
}

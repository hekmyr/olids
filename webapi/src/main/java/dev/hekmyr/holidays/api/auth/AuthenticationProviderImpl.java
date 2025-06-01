package dev.hekmyr.holidays.api.auth;

import java.util.Arrays;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
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
        try {
            var username = authentication.getName();
            var rawPassword = authentication.getCredentials();

            var userDetails = userDetailsManagerImpl.loadUserByUsername(
                username
            );
            var encodedPassword = userDetails.getPassword();

            if (
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
            } else throw new BadCredentialsException("Invalid password");
        } catch (Exception ex) {
            throw new BadCredentialsException(
                "Invalid username or password",
                ex
            );
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(
                authentication
            );
    }
}

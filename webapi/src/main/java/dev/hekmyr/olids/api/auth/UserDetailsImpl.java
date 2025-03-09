package dev.hekmyr.olids.api.auth;

import dev.hekmyr.olids.api.entity.User;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails {

  private String username;
  private String password;

  public UserDetailsImpl() {}

  public UserDetailsImpl(User entity) {
    if (entity == null) {
      throw new IllegalArgumentException("User entity cannot be null");
    }
    username = entity.getEmail();
    password = entity.getPassword();
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    var col = new ArrayList<GrantedAuthority>();
    return col;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public String getPassword() {
    return password;
  }
}

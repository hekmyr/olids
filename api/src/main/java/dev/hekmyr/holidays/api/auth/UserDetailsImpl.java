package dev.hekmyr.holidays.api.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import dev.hekmyr.holidays.api.dto.OdooUserDTO;
import dev.hekmyr.holidays.api.exception.InternalErrorException;

public class UserDetailsImpl implements UserDetails {

    private String username;
    private String password;

    public UserDetailsImpl() {}

    public UserDetailsImpl(OdooUserDTO dto) throws InternalErrorException {
        if (dto == null) {
            throw new UsernameNotFoundException("User cannot be null");
        }
        username = dto.getEmail();
        password = dto.getPassword();
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

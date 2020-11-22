package de.vilaca.Kochbuch.security;

import de.vilaca.Kochbuch.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserDetails implements org.springframework.security.core.userdetails.UserDetails {

    private String name;
    private String pWord;
    private boolean enabled;
    private List<GrantedAuthority> authorities;

    public UserDetails(User user) {
        this.name = user.getUsername();
        this.pWord = user.getPassword();
        this.enabled = user.isEnabled();
        this.authorities = user.getAuthorities()
                        .stream()
                        .map(x -> {
                            return new SimpleGrantedAuthority(x.getName());
                        })
                        .collect(Collectors.toList());
    }

    public UserDetails() {

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return pWord;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}

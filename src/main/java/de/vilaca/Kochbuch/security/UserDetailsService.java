package de.vilaca.Kochbuch.security;

import de.vilaca.Kochbuch.domain.User;
import de.vilaca.Kochbuch.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Transactional // makes the whole method call happen within a db
    // transaction so that lazy fetching for authorities is possible.
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findUserByUsernameEquals(name);
        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + name));
        return user.map(de.vilaca.Kochbuch.security.UserDetails::new).get();
    }
}

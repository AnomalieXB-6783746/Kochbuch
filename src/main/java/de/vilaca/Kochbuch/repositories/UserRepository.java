package de.vilaca.Kochbuch.repositories;

import de.vilaca.Kochbuch.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findUserByUsernameEquals(String name);


}

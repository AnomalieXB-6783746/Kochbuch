package de.vilaca.Kochbuch.repositories;

import de.vilaca.Kochbuch.domain.Authority;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AuthorityRepository extends CrudRepository<Authority, Long> {

    public Optional<Authority> findAuthorityByName(String name);

}

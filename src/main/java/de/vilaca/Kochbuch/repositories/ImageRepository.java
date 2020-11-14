package de.vilaca.Kochbuch.repositories;

import de.vilaca.Kochbuch.domain.Image;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface ImageRepository extends CrudRepository<Image, Integer> {
    Set<Image> findByName(String name);
}

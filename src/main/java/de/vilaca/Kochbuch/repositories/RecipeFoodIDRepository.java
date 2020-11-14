package de.vilaca.Kochbuch.repositories;

import de.vilaca.Kochbuch.domain.Food;
import org.springframework.data.repository.CrudRepository;

public interface RecipeFoodIDRepository extends CrudRepository<Food, Integer> {
    Food findByName(String name);// TODO Set<Food> als Rückgabe?
}

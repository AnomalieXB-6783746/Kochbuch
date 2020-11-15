package de.vilaca.Kochbuch.repositories;

import de.vilaca.Kochbuch.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface RecipeFoodIDRepository extends CrudRepository<Ingredient, Integer> {
    Ingredient findByName(String name);// TODO Set<Food> als Rückgabe?
}

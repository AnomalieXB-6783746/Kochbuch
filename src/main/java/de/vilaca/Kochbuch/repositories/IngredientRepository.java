package de.vilaca.Kochbuch.repositories;

import de.vilaca.Kochbuch.domain.Ingredient;
import de.vilaca.Kochbuch.domain.RecipeFoodID;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, RecipeFoodID> {
}

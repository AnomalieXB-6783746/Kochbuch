package de.vilaca.Kochbuch.repositories;

import de.vilaca.Kochbuch.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
}

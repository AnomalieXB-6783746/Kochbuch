package de.vilaca.Kochbuch.repositories;

import de.vilaca.Kochbuch.domain.ConcreteIngredient;
import de.vilaca.Kochbuch.domain.RecipeFoodID;
import org.springframework.data.repository.CrudRepository;

public interface ConcreteIngredientRepository extends CrudRepository<ConcreteIngredient, RecipeFoodID> {
}

package de.vilaca.Kochbuch.repositories;

import de.vilaca.Kochbuch.domain.Food;
import org.springframework.data.repository.CrudRepository;

public interface FoodRepository extends CrudRepository<Food, Integer> {
    Food findByName(String name);
}

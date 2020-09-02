package de.vilaca.Kochbuch.repositories;

import de.vilaca.Kochbuch.domain.MealType;
import org.springframework.data.repository.CrudRepository;

public interface MealTypeRepository extends CrudRepository<MealType, Integer> {
    MealType findByName(String name);
}

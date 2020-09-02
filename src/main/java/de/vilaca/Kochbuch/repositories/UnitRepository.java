package de.vilaca.Kochbuch.repositories;

import de.vilaca.Kochbuch.domain.Unit;
import org.springframework.data.repository.CrudRepository;

public interface UnitRepository extends CrudRepository<Unit, Integer> {
    public Iterable<Unit> getByName(String name);
}

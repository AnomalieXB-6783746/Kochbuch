package de.vilaca.Kochbuch.repositories;

import de.vilaca.Kochbuch.domain.Recipe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface RecipeRepository extends PagingAndSortingRepository<Recipe, Integer> {
    public Iterable<Recipe> findByName(String name);

    public Optional<Recipe> findById(Long id);

    public Page<Recipe> findAll(Pageable pageable);
}

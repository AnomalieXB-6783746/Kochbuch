package de.vilaca.Kochbuch.services;

import de.vilaca.Kochbuch.domain.Recipe;
import de.vilaca.Kochbuch.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Optional<Recipe> findById(Long id) {
        return recipeRepository.findById(id);
    }

    public List<Recipe> getRecipes(int page, int size) {
        if (page <= 0 || size <= 0) {
            return new ArrayList<>();
        } else {
            return recipeRepository.findAll(PageRequest.of(page - 1, size)).getContent();
        }
    }

}

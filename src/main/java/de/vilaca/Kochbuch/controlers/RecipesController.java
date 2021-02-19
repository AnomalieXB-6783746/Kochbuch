package de.vilaca.Kochbuch.controlers;

import de.vilaca.Kochbuch.domain.Recipe;
import de.vilaca.Kochbuch.services.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecipesController {

    private final RecipeService recipeService;

    public RecipesController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipes")
    public List<Recipe> getRecipes(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        return recipeService.getRecipes(page, size);
    }

    @RequestMapping("/recipe")
    public ResponseEntity<Recipe> getRecipe(
            @RequestParam(value = "id") Long id) {
        Recipe result = recipeService.findById(id).orElse(null);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }



}

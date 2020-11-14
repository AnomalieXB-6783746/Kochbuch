package de.vilaca.Kochbuch.bootstrap;

import de.vilaca.Kochbuch.KochbuchApplication;
import de.vilaca.Kochbuch.domain.*;
import de.vilaca.Kochbuch.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

@Component
public class BootstrapData implements CommandLineRunner {

    private final UnitRepository unitRepository;
    private final RecipeRepository recipeRepository;
    private final ImageRepository imageRepository;
    private final FoodRepository foodRepository;
    private final IngredientRepository ingredientRepository;

    public BootstrapData(UnitRepository unitRepository, RecipeRepository recipeRepository,
                         ImageRepository imageRepository, FoodRepository foodRepository,
                         IngredientRepository ingredientRepository) {
        this.unitRepository = unitRepository;
        this.recipeRepository = recipeRepository;
        this.imageRepository = imageRepository;
        this.foodRepository = foodRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //saveCeviche();
    }

    private void saveCeviche() {
        Image imageCeviche = new Image("Ceviche", "Data/Ceviche.JPG");
        Set<Ingredient> ingredients = new HashSet<>();
        Recipe cevice = new Recipe("Cevice", imageCeviche, "", new HashSet<>(),
                Boolean.FALSE, Boolean.TRUE, Boolean.FALSE,
                Boolean.FALSE, 10, 20, 30, 4);
        {
            Unit unit = new Unit("Stück");
            Food food = new Food("rote Zwiebel");
            RecipeFoodID id = new RecipeFoodID(cevice, food);
            Ingredient ingredient = new Ingredient(id, unit, 1);
            ingredients.add(ingredient);
            cevice.addIngredients(ingredients);
            unitRepository.save(unit);
            foodRepository.save(food);
            if (!imageRepository.findByName(imageCeviche.getName()).iterator().hasNext()) {
                imageRepository.save(imageCeviche);
            }
            if (!recipeRepository.getByName(cevice.getName()).iterator().hasNext()) {
                recipeRepository.save(cevice);
            }
            ingredientRepository.save(ingredient);
        }
    }
}

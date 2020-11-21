package de.vilaca.Kochbuch.bootstrap;

import de.vilaca.Kochbuch.domain.*;
import de.vilaca.Kochbuch.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class BootstrapData implements CommandLineRunner {

    private final UnitRepository unitRepository;
    private final RecipeRepository recipeRepository;
    private final ImageRepository imageRepository;
    private final IngredientRepository ingredientRepository;
    private final ConcreteIngredientRepository concreteIngredientRepository;

    public BootstrapData(UnitRepository unitRepository,
                         RecipeRepository recipeRepository,
                         ImageRepository imageRepository,
                         IngredientRepository ingredientRepository,
                         ConcreteIngredientRepository concreteIngredientRepository) {
        this.unitRepository = unitRepository;
        this.recipeRepository = recipeRepository;
        this.imageRepository = imageRepository;
        this.ingredientRepository = ingredientRepository;
        this.concreteIngredientRepository = concreteIngredientRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //saveCeviche();
    }

    /*private void saveCeviche() {
        Image imageCeviche = new Image("Ceviche", "Data/Ceviche.JPG");
        //Set<ConcreteIngredient> concreteIngredients = new HashSet<>();
        Recipe cevice = new Recipe("Cevice", imageCeviche, "", new HashSet<>(),
                Boolean.FALSE, Boolean.TRUE, Boolean.FALSE,
                Boolean.FALSE, 10, 20, 30, 4);
        imageCeviche.addRecipe(cevice);
        imageRepository.save(imageCeviche);
        cevice = recipeRepository.save(cevice);
        {
            Unit unit = new Unit("Stück");
            unit = unitRepository.save(unit);
            Ingredient ingredient = new Ingredient("Zwiebel (rot)");
            ingredient = ingredientRepository.save(ingredient);
            RecipeFoodID id = new RecipeFoodID(cevice, ingredient);
            ConcreteIngredient concreteIngredient = new ConcreteIngredient(id, unit, 1);
            concreteIngredient =
                    concreteIngredientRepository.save(concreteIngredient);

            concreteIngredient.setUnit(unit);
            concreteIngredient =
                    concreteIngredientRepository.save(concreteIngredient);
            unit.addIngredient(concreteIngredient);
            unit = unitRepository.save(unit);

            //concreteIngredients.add(concreteIngredient);
            *//*cevice.addIngredients(concreteIngredients);*//*
            //foodRepository.save(ingredient);
            //ingredientRepository.save(ingredient);

            if (!imageRepository.findByName(imageCeviche.getName()).iterator().hasNext()) {
                imageRepository.save(imageCeviche);
            }
            if (!recipeRepository.getByName(cevice.getName()).iterator().hasNext()) {
                recipeRepository.save(cevice);
            }
        }
    }*/
}

package de.vilaca.Kochbuch.bootstrap;

import de.vilaca.Kochbuch.domain.*;
import de.vilaca.Kochbuch.repositories.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManagerFactory;
import java.util.HashSet;
import java.util.Set;

@Component
public class BootstrapData implements CommandLineRunner {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthorityRepository authorityRepository;
    @Autowired
    UserRepository userRepository;

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
        /*Session session = sessionFactory.openSession();
        saveCeviche();
        //addMyUser();
        session.close();*/
    }

    private void addMyUser() {
        if (!userRepository.findUserByUsernameEquals("user").isPresent()
                || !authorityRepository.findAuthorityByName("ADMIN").isPresent()) {
            Authority authority = new Authority("ADMIN");
            User user = new User("user", passwordEncoder.encode("geheim"),
                    "sample@email.de");
            user.addAuthority(authority);
            userRepository.save(user);
            authority.addUser(user);
            authorityRepository.save(authority);
            System.out.println("Benutzer erstellt!!");
        }
    }

    /*private void saveCeviche() {
        Image imageCeviche = new Image("Ceviche", "Data/Ceviche.JPG");
        Set<ConcreteIngredient> concreteIngredients = new HashSet<>();
        Recipe cevice = new Recipe("Cevice", imageCeviche, "", new HashSet<>(),
                Boolean.FALSE, Boolean.TRUE, Boolean.FALSE,
                Boolean.FALSE, 10, 20, 30, 4);
        //imageCeviche.addRecipe(cevice);
        imageRepository.save(imageCeviche);
        cevice = recipeRepository.save(cevice);
        {
            Unit unit = new Unit("Stück");

            if (!unitRepository.findByName(unit.getName()).iterator().hasNext()) {
                unit = unitRepository.save(unit);
            } else {
                unit = unitRepository.findByName(unit.getName()).iterator().next();
            }

            Ingredient ingredient = new Ingredient("Zwiebel (rot)");

            if (ingredientRepository.findByName(ingredient.getName()) == null) {
                ingredient = ingredientRepository.save(ingredient);
            } else {
                ingredient = ingredientRepository.findByName(ingredient.getName());
            }

            RecipeFoodID id = new RecipeFoodID(cevice, ingredient);
            ConcreteIngredient concreteIngredient = new ConcreteIngredient(id, unit, 1);

            if (concreteIngredientRepository
                    .findByPrimaryKey(concreteIngredient.getPrimaryKey()) == null) {
                concreteIngredient =
                        concreteIngredientRepository.save(concreteIngredient);
            }

            concreteIngredient.setUnit(unit);

            concreteIngredient =
                    concreteIngredientRepository.save(concreteIngredient);
            unit.addIngredient(concreteIngredient);

            if (unitRepository.findByName(unit.getName()) == null) {
                unit = unitRepository.save(unit);
            }

            concreteIngredients.add(concreteIngredient);
            cevice.addIngredients(concreteIngredients);
            *//*foodRepository.save(ingredient);*//*

            if (ingredientRepository.findByName(ingredient.getName()) == null) {
                ingredient = ingredientRepository.save(ingredient);
            }

            if (!imageRepository.findByName(imageCeviche.getName()).iterator().hasNext()) {
                imageCeviche = imageRepository.save(imageCeviche);
            }
            if (!recipeRepository.getByName(cevice.getName()).iterator().hasNext()) {
                cevice = recipeRepository.save(cevice);
            }
        }
    }*/
}

package de.vilaca.Kochbuch.controlers;

import de.vilaca.Kochbuch.HibernateConf;
import de.vilaca.Kochbuch.domain.Recipe;
import de.vilaca.Kochbuch.repositories.ImageRepository;
import de.vilaca.Kochbuch.repositories.RecipeRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.*;
import java.util.ArrayList;

@Controller
public class RecipesController {

    @Value("${images.defaultPath}")
    private String defaultImage;

/*    private static EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("de.vilaca.Kochbuch.controlers.RecipesController.example");*/

    /*@Autowired
    private SessionFactory sessionFactory;*/

    private final RecipeRepository recipeRepository;
    private final ImageRepository imageRepository;

    private static final String homePage = "/home";
    private static final String newRecipePage = "/addRecipe";

    public RecipesController(RecipeRepository recipeRepository, ImageRepository imageRepository) {
        this.recipeRepository = recipeRepository;
        this.imageRepository = imageRepository;
    }

    @RequestMapping("/home")
    public String getRecipes(Model model/*,
                             @RequestParam(name = "id", required = true, defaultValue = "1") String id*/) {

        /*Integer rId = Integer.parseInt(id);
        ArrayList ids = new ArrayList();
        ids.add(rId);
        model.addAttribute("recipes", recipeRepository.findAllById(ids));*/
/*        model.addAttribute("recipes", recipeRepository.findAll());
        model.addAttribute("images", imageRepository.findAll());*/

        Iterable<Recipe> recipes = new ArrayList<>();
        /*List<Recipe> sqlOut;*/

        SessionFactory sessionFactory = HibernateConf.getSessionFactory();
        EntityManager manager = sessionFactory.createEntityManager();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        String statement = "SELECT recipe FROM Recipe recipe";
        TypedQuery<Recipe> query = manager.createQuery(statement, Recipe.class);
        recipes = query.getResultList();
        /*String statement = "SELECT recipe.name, image.path FROM Recipe recipe INNER JOIN Image image ON recipe.image = image";
        Query query = manager.createQuery(statement);
        sqlOut = query.getResultList();
        */
        /*for (Object entry: sqlOut) {
            Object[] real = (Object[]) entry;
            recipes.add(new Result(real[0].toString(), real[1].toString()));
        }*/
        session.getTransaction().commit();
        session.close();

        model.addAttribute("recipes", recipes);
        model.addAttribute("defaultImage", defaultImage);
        model.addAttribute("homePage", homePage);
        model.addAttribute("newRecipePage", newRecipePage);

        return "cssandjs/list";
    }

    public class Result {
        final String name;
        final String path;

        public Result(String name, String path) {
            this.name = name;
            this.path = path;
        }

        public String getName() {
            return name;
        }

        public String getPath() {
            return path;
        }
    }

}

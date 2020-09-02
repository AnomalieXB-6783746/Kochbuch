package de.vilaca.Kochbuch.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "recipe_id")
    private Integer id;

    @Column(length = 20, nullable = false)
    private String name;

    /**
     * The url to an image showing the meal.
     */
    @Column(length = 50)
    private String img_url;

    /**
     * The url pointing to a JSON document containing the steps for this recipe.
     */
    @Column(length = 50, nullable = false)
    private String steps_url;

    /**
     * Whether the recipe contains meat or not.
     */
    @Column(nullable = false)
    private Boolean meat;

    /**
     * Whether the recipe contains fish.
     */
    @Column(nullable = false)
    private Boolean fish;

    /**
     * Whether the recipe is vegetarian (no meat or fish)
     */
    @Column(nullable = false)
    private Boolean vegetarian;

    /**
     * Whether the recipe is vegan (no animal products)
     */
    @Column(nullable = false)
    private Boolean vegan;

    /**
     * The amount of carbon hydrates this meal is worth.
     */
    @Column(nullable = true)
    private Integer carbs;

    /**
     * The amount of protein this meal is worth.
     */
    @Column(nullable = true)
    private Integer protein;

    /**
     * The amount of calories this meal is worth.
     */
    @Column(nullable = true)
    private Integer calories;

    /**
     * The amount of portions this recipe is for.
     */
    @Column(nullable = false)
    private Integer portions;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "recipe_meal",
            joinColumns = {@JoinColumn(name = "recipe_id")},
            inverseJoinColumns = {@JoinColumn(name = "meal_id")}
    )
    private Set<MealType> mealTypes = new HashSet<>();

    @OneToMany(mappedBy = "primaryKey.recipe")
    private Set<Ingredient> ingredients = new HashSet<>();

    public Recipe() {};

    public Recipe(String name, String img_url, String steps_url, Boolean meat, Boolean fish,
                  Boolean vegetarian, Boolean vegan, Integer carbs, Integer protein,
                  Integer calories, Integer portions, Set<MealType> mealTypes,
                  Set<Ingredient> ingredients) {
        this.name = name;
        this.img_url = img_url;
        this.steps_url = steps_url;
        this.meat = meat;
        this.fish = fish;
        this.vegetarian = vegetarian;
        this.vegan = vegan;
        this.carbs = carbs;
        this.protein = protein;
        this.calories = calories;
        this.portions = portions;
        this.mealTypes = mealTypes;
        this.ingredients = ingredients;
    }

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }
}

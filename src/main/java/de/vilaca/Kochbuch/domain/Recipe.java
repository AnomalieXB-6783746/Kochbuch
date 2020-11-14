package de.vilaca.Kochbuch.domain;

import javax.persistence.*;
import java.util.Collection;
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
/*
    *//**
     * The url to an image showing the meal.
     *//*
    @Column(length = 50)
    private String img_url;*/

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

    @ManyToOne(targetEntity = Image.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "image_id")
    private Image image;

    public Recipe() {};

    public Recipe(String name, Image image, String steps_url, Set<Ingredient> ingredients, Boolean meat, Boolean fish,
                  Boolean vegetarian, Boolean vegan, Integer carbs, Integer protein,
                  Integer calories, Integer portions) {
        this.name = name;
        this.steps_url = steps_url;
        this.meat = meat;
        this.fish = fish;
        this.vegetarian = vegetarian;
        this.vegan = vegan;
        this.carbs = carbs;
        this.protein = protein;
        this.calories = calories;
        this.portions = portions;
        this.image = image;
        this.ingredients = (ingredients != null) ? ingredients : new HashSet<>();
    }

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }

    public void addIngredients(Collection<Ingredient> ingredients) {
        this.ingredients.addAll(ingredients);
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSteps_url() {
        return steps_url;
    }

    public void setSteps_url(String steps_url) {
        this.steps_url = steps_url;
    }

    public Boolean getMeat() {
        return meat;
    }

    public void setMeat(Boolean meat) {
        this.meat = meat;
    }

    public Boolean getFish() {
        return fish;
    }

    public void setFish(Boolean fish) {
        this.fish = fish;
    }

    public Boolean getVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(Boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public Boolean getVegan() {
        return vegan;
    }

    public void setVegan(Boolean vegan) {
        this.vegan = vegan;
    }

    public Integer getCarbs() {
        return carbs;
    }

    public void setCarbs(Integer carbs) {
        this.carbs = carbs;
    }

    public Integer getProtein() {
        return protein;
    }

    public void setProtein(Integer protein) {
        this.protein = protein;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Integer getPortions() {
        return portions;
    }

    public void setPortions(Integer portions) {
        this.portions = portions;
    }

    public Set<MealType> getMealTypes() {
        return mealTypes;
    }

    public void setMealTypes(Set<MealType> mealTypes) {
        this.mealTypes = mealTypes;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}

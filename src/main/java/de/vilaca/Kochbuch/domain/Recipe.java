package de.vilaca.Kochbuch.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "recipes")
public class Recipe {

    private Integer id;

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
    private String steps_url;

    /**
     * Whether the recipe contains meat or not.
     */
    private Boolean meat;

    /**
     * Whether the recipe contains fish.
     */
    private Boolean fish;

    /**
     * Whether the recipe is vegetarian (no meat or fish)
     */
    private Boolean vegetarian;

    /**
     * Whether the recipe is vegan (no animal products)
     */
    private Boolean vegan;

    /**
     * The amount of carbon hydrates this meal is worth.
     */
    private Integer carbs;

    /**
     * The amount of protein this meal is worth.
     */
    private Integer protein;

    /**
     * The amount of calories this meal is worth.
     */
    private Integer calories;

    /**
     * The amount of portions this recipe is for.
     */
    private Integer portions;

    private Set<MealType> mealTypes = new HashSet<>();

    private Set<ConcreteIngredient> concreteIngredients = new HashSet<>();

    private Image image;

    private LocalDateTime created;

    private LocalDateTime lastModified;

    private User creator;

    public Recipe() {};

    public Recipe(String name, Image image, String steps_url, Set<ConcreteIngredient> concreteIngredients, Boolean meat, Boolean fish,
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
        this.concreteIngredients = (concreteIngredients != null) ? concreteIngredients : new HashSet<>();
        this.created = LocalDateTime.now();
        this.lastModified = this.created;
    }

    public void addIngredient(ConcreteIngredient concreteIngredient) {
        this.concreteIngredients.add(concreteIngredient);
    }

    public void addIngredients(Collection<ConcreteIngredient> concreteIngredients) {
        this.concreteIngredients.addAll(concreteIngredients);
    }

    @OneToMany(mappedBy = "primaryKey.recipe",
            fetch = FetchType.LAZY)
    public Set<ConcreteIngredient> getIngredients() {
        return concreteIngredients;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "recipe_id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(length = 20, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(length = 50, nullable = false)
    public String getSteps_url() {
        return steps_url;
    }

    public void setSteps_url(String steps_url) {
        this.steps_url = steps_url;
    }

    @Column(nullable = false)
    public Boolean getMeat() {
        return meat;
    }

    public void setMeat(Boolean meat) {
        this.meat = meat;
    }

    @Column(nullable = false)
    public Boolean getFish() {
        return fish;
    }

    public void setFish(Boolean fish) {
        this.fish = fish;
    }

    @Column(nullable = false)
    public Boolean getVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(Boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    @Column(nullable = false)
    public Boolean getVegan() {
        return vegan;
    }

    public void setVegan(Boolean vegan) {
        this.vegan = vegan;
    }

    @Column(nullable = true)
    public Integer getCarbs() {
        return carbs;
    }

    public void setCarbs(Integer carbs) {
        this.carbs = carbs;
    }

    @Column(nullable = true)
    public Integer getProtein() {
        return protein;
    }

    public void setProtein(Integer protein) {
        this.protein = protein;
    }

    @Column(nullable = true)
    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    @Column(nullable = false)
    public Integer getPortions() {
        return portions;
    }

    public void setPortions(Integer portions) {
        this.portions = portions;
    }

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "recipe_meal",
            joinColumns = {@JoinColumn(name = "recipe_id")},
            inverseJoinColumns = {@JoinColumn(name = "meal_id")}
    )
    public Set<MealType> getMealTypes() {
        return mealTypes;
    }

    public void setMealTypes(Set<MealType> mealTypes) {
        this.mealTypes = mealTypes;
    }

    public void setIngredients(Set<ConcreteIngredient> concreteIngredients) {
        this.concreteIngredients = concreteIngredients;
    }

    @ManyToOne(targetEntity = Image.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "image_id")
    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @Basic(optional = false, fetch = FetchType.LAZY)
    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @Basic(optional = false, fetch = FetchType.LAZY)
    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public User getCreator() {
        return creator;
    }

    public void setCreator(User user) {
        this.creator = user;
    }
}

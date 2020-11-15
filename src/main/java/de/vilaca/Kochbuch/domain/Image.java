package de.vilaca.Kochbuch.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "image")
public class Image {

    private Integer id;

    private String name;

    private String path;

    private Set<Recipe> recipes = new HashSet<>();

    public Image() {
    }

    public Image(String name, String path) {
        this.name = name;
        this.path = path;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "image_id")
    public Integer getId() {
        return id;
    }

    @Column(name = "image_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "image_path")
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @OneToMany(targetEntity = Recipe.class,
            mappedBy = "image",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }

    public boolean addRecipe(Recipe recipe) {
        return this.recipes.add(recipe);
    }

    public boolean removeRecipe(Recipe recipe) {
        return this.recipes.remove(recipe);
    }
}

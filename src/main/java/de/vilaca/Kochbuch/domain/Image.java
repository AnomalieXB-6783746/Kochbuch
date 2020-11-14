package de.vilaca.Kochbuch.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "image")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "image_id")
    private Integer id;

    @Column(name = "image_name")
    private String name;

    @Column(name = "image_path")
    private String path;

    @OneToMany(targetEntity = Recipe.class,
            mappedBy = "image",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private Set<Recipe> recipes = new HashSet<>();

    public Image() {
    }

    public Image(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }
}

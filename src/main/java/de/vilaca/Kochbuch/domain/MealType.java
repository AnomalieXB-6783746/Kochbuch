package de.vilaca.Kochbuch.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "meal_types")
public class MealType {

    private Long id;

    private String name;

    private Set<Recipe> recipes = new HashSet<>();

    public MealType() {
    }

    public MealType(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(nullable = false, length = 20, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "mealTypes",
            fetch = FetchType.LAZY)
    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MealType mealType = (MealType) o;

        return id != null ? id.equals(mealType.id) : mealType.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "MealType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

package de.vilaca.Kochbuch.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "mealType")
public class MealType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, length = 20)
    private String name;

    @ManyToMany(mappedBy = "mealTypes")
    private Set<Recipe> recipes = new HashSet<>();

    public MealType() {
    }

    public MealType(String name) {
        this.name = name;
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

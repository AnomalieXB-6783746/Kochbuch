package de.vilaca.Kochbuch.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * A type of food (a specific food). 
 */
@Entity
@Table(name = "ingredient")
public class Ingredient {

    private Integer id;

    private String name;

    private Set<ConcreteIngredient> concreteIngredients = new HashSet<ConcreteIngredient>();

    public Ingredient() {
    }

    public Ingredient(String name) {
        this.name = name;
    }

    public void addConcreteIngredient(ConcreteIngredient concreteIngredient) {
        this.concreteIngredients.add(concreteIngredient);
    }

    public void addConcreteIngredients(Collection<ConcreteIngredient> concreteIngredients) {
        this.concreteIngredients.addAll(concreteIngredients);
    }

    @OneToMany(mappedBy = "primaryKey.food",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    public Set<ConcreteIngredient> getConcreteIngredients() {
        return concreteIngredients;
    }

    public void setConcreteIngredients(Set<ConcreteIngredient> concreteIngredients) {
        this.concreteIngredients = concreteIngredients;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(nullable = false, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ingredient ingredient = (Ingredient) o;

        return id != null ? id.equals(ingredient.id) : ingredient.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

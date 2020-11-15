package de.vilaca.Kochbuch.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "unit")
public class Unit {

    private Integer id;

    private String name;

    private Set<ConcreteIngredient> concreteIngredients = new HashSet<>();

    public Unit() {
    }

    public Unit(String name) {
        this.name = name;
    }

    @OneToMany(
            mappedBy = "unit",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    public Set<ConcreteIngredient> getIngredients() {
        return concreteIngredients;
    }

    public void setIngredients(Set<ConcreteIngredient> concreteIngredients) {
        this.concreteIngredients = concreteIngredients;
    }

    public void addIngredient(ConcreteIngredient concreteIngredient) {
        concreteIngredients.add(concreteIngredient);
        concreteIngredient.setUnit(this);
    }

    public void removeIngredient(ConcreteIngredient concreteIngredient) {
        concreteIngredients.remove(concreteIngredient);
        concreteIngredient.setUnit(null);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(nullable = false, length = 10, unique = true, name = "name")
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

        Unit unit = (Unit) o;

        return id != null ? id.equals(unit.id) : unit.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

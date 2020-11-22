package de.vilaca.Kochbuch.domain;

import javax.persistence.*;

/**
 * An concrete ingredient as in an ingredient combined with its corresponding
 * unit of measure and quantity in a specific meal.
 */
@Entity
@Table(name = "concreteIngredients")
@AssociationOverrides({
        @AssociationOverride(name = "primaryKey.recipe",
                joinColumns = @JoinColumn(name = "recipe_id")),
        @AssociationOverride(name = "primaryKey.food",
                joinColumns = @JoinColumn(name = "ingredient_id"))
})
public class ConcreteIngredient {
    //composite id key
    private RecipeFoodID primaryKey = new RecipeFoodID();

    /**
     * The unit this ingredient is messured in.
     */
    private Unit unit;

    /**
     * The quantity this ingredient represents.
     */
    private Integer quantity;

    public ConcreteIngredient(RecipeFoodID primaryKey, Unit unit, Integer quantity) {
        this.primaryKey = primaryKey;
        this.unit = unit;
        this.quantity = quantity;
    }

    public ConcreteIngredient() {
    }

    @ManyToOne (fetch = FetchType.LAZY)
    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    @EmbeddedId
    public RecipeFoodID getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(RecipeFoodID primaryKey) {
        this.primaryKey = primaryKey;
    }

    @Transient
    public Recipe getRecipe() {
        return getPrimaryKey().getRecipe();
    }

    public void setRecipe(Recipe recipe) {
        this.getPrimaryKey().setRecipe(recipe);
    }

    @Transient
    public Ingredient getFood() {
        return getPrimaryKey().getFood();
    }

    public void setFood(Ingredient ingredient) {
        this.getPrimaryKey().setFood(ingredient);
    }

    @Column(name = "quantity", nullable = false)
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConcreteIngredient that = (ConcreteIngredient) o;

        return primaryKey != null
                ? primaryKey.equals(that.primaryKey)
                : that.primaryKey == null;
    }

    @Override
    public int hashCode() {
        return primaryKey != null ? primaryKey.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "primaryKey=" + primaryKey.toString() +
                ", unit=" + unit.toString() +
                ", quantity=" + quantity +
                '}';
    }
}

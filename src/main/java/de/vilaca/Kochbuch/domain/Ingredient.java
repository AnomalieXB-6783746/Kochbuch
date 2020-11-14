package de.vilaca.Kochbuch.domain;

import javax.persistence.*;

/**
 * An ingredient as part of a meal.
 */
@Entity
@Table(name = "ingredient")
@AssociationOverrides({
        @AssociationOverride(name = "primaryKey.recipe",
                joinColumns = @JoinColumn(name = "recipe_id")),
        @AssociationOverride(name = "primaryKey.food",
                joinColumns = @JoinColumn(name = "food_id"))
})
public class Ingredient {
    //composite id key
    private RecipeFoodID primaryKey = new RecipeFoodID();

    /*@Column(name = "unit_id", nullable = false)
    private Integer unit_id;*/

    //@JoinColumn (name = "unit_id")
    /**
     * The unit this ingredient is messured in.
     */
    private Unit unit;

    /**
     * The quantity this ingredient represents.
     */
    private Integer quantity;

    public Ingredient(RecipeFoodID primaryKey, Unit unit, Integer quantity) {
        this.primaryKey = primaryKey;
        this.unit = unit;
        this.quantity = quantity;
    }

    public Ingredient() {
    }

    @ManyToOne (/*targetEntity = Unit.class, */fetch = FetchType.LAZY)
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
    public Food getFood() {
        return getPrimaryKey().getFood();
    }

    public void setFood(Food food) {
        this.getPrimaryKey().setFood(food);
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

        Ingredient that = (Ingredient) o;

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

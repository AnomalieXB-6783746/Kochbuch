package de.vilaca.Kochbuch.domain;

import javax.persistence.*;

@Entity
@Table(name = "ingredients")
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

    @ManyToOne (targetEntity = Unit.class, fetch = FetchType.LAZY)
    @JoinColumn (name = "unit_id")
    private Unit unit;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    public Integer getUnit() {
        return unit.getId();
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    /*public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }*/

    /*public Integer getUnit_id() {
        return unit_id;
    }

    public void setUnit_id(Integer unit_id) {
        this.unit_id = unit_id;
    }*/

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

        return primaryKey != null ? primaryKey.equals(that.primaryKey) : that.primaryKey == null;
    }

    @Override
    public int hashCode() {
        return primaryKey != null ? primaryKey.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "primaryKey=" + primaryKey +
                ", unit=" /*+ unit_id*/ +
                ", quantity=" + quantity +
                '}';
    }
}

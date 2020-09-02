package de.vilaca.Kochbuch.domain;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class RecipeFoodID implements Serializable {
    private Recipe recipe;
    private Food food;

    public RecipeFoodID() {
    }

    public RecipeFoodID(Recipe recipe, Food food) {
        this.recipe = recipe;
        this.food = food;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecipeFoodID that = (RecipeFoodID) o;

        if (recipe != null ? !recipe.equals(that.recipe) : that.recipe != null) return false;
        return food != null ? food.equals(that.food) : that.food == null;
    }

    @Override
    public int hashCode() {
        int result = recipe != null ? recipe.hashCode() : 0;
        result = 31 * result + (food != null ? food.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RecipeFoodID{" +
                "recipe=" + recipe +
                ", food=" + food +
                '}';
    }
}

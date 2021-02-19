package de.vilaca.Kochbuch.domain;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class RecipeFoodID implements Serializable {

    private Recipe recipe;

    private Ingredient ingredient;

    public RecipeFoodID() {
    }

    public RecipeFoodID(Recipe recipe, Ingredient ingredient) {
        this.recipe = recipe;
        this.ingredient = ingredient;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    public Ingredient getFood() {
        return ingredient;
    }

    public void setFood(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecipeFoodID that = (RecipeFoodID) o;

        if (recipe != null ? !recipe.equals(that.recipe) : that.recipe != null) return false;
        return ingredient != null ? ingredient.equals(that.ingredient) : that.ingredient == null;
    }

    @Override
    public int hashCode() {
        int result = recipe != null ? recipe.hashCode() : 0;
        result = 31 * result + (ingredient != null ? ingredient.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RecipeFoodID{" +
                "recipe=" + recipe.getName() +
                ", food=" + ingredient.toString() +
                '}';
    }
}

package ec.utb.JPA_Assignment.Entity;

import javax.persistence.*;
import java.util.Objects;

/*
. Klass: Ingredient (Ingrediens)
a. Innehåller en id av typen int.
b. Innehåller ett namn på ingrediensen som är unikt.
 */
@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id")
    private int ingredientId;

    @Column(unique = true)
    private String ingredientName;

    public Ingredient(String name) {
        this.ingredientName = name;
    }

    Ingredient() {}

    public int getIngredientId(){
        return ingredientId;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ingredient)) return false;
        Ingredient that = (Ingredient) o;
        return ingredientId == that.ingredientId &&
                Objects.equals(ingredientName, that.ingredientName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredientId, ingredientName);
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + ingredientId +
                ", name='" + ingredientName + '\'' +
                '}';
    }
}

package ec.utb.JPA_Assignment.Entity;

import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/*
6. Klass: RecipeInstruction (Receptinstruktion)
a. Innehåller en id av typen String. Ska genereras som ett UUID av Hibernate.
b. Innehåller instruktionen av typen String.
 */
@Entity
public class RecipeInstruction {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String recipeInstructionId;

    private String recipeInstruction;

    public RecipeInstruction(String recipeInstruction) {
        this.recipeInstruction = recipeInstruction;
    }
    public RecipeInstruction(){}

    public String getRecipeInstructionId() {
        return recipeInstructionId;
    }


    public String getRecipeInstruction() {
        return recipeInstruction;
    }

    public void setRecipeInstruction(String recipeInstruction) {
        this.recipeInstruction = recipeInstruction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecipeInstruction)) return false;
        RecipeInstruction that = (RecipeInstruction) o;
        return recipeInstructionId == that.recipeInstructionId &&
                Objects.equals(recipeInstruction, that.recipeInstruction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeInstructionId, recipeInstruction);
    }

    @Override
    public String toString() {
        return "RecipeInstruction{" +
                "recipeInstructionId=" + recipeInstructionId +
                ", recipeInstruction=" + recipeInstruction +
                '}';
    }
}

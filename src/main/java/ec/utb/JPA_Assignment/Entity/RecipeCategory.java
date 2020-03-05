package ec.utb.JPA_Assignment.Entity;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/*
Klass: RecipeCategory (Receptkategori)
a. Innehåller en id av typen int.
b. Innehåller kategorinamnet av typen String.
c. Innehåller en samling recept som har den här kategorin. (List, Set…)
 */
@Entity
public class RecipeCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recipeCategoryId;

    private String recipeCategoryName;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
            mappedBy = "recipeCategories"
    )
    private List<Recipe> recipeList;

    public RecipeCategory(String recipeCategoryName, List<Recipe> recipeList) {
        this.recipeCategoryName = recipeCategoryName;
        this.recipeList = recipeList;
    }
    
    
    public RecipeCategory(){}

    public RecipeCategory(String recipeCategoryName) {
        this.recipeCategoryName = recipeCategoryName;
    }

    public int getRecipeCategoryId() {
        return recipeCategoryId;
    }

    public String getRecipeCategoryName() {
        return recipeCategoryName;
    }

    public void setRecipeCategoryName(String recipeCategoryName) {
        this.recipeCategoryName = recipeCategoryName;
    }

    public List<Recipe> getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecipeCategory)) return false;
        RecipeCategory that = (RecipeCategory) o;
        return recipeCategoryId == that.recipeCategoryId &&
                Objects.equals(recipeCategoryName, that.recipeCategoryName) &&
                Objects.equals(recipeList, that.recipeList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeCategoryId, recipeCategoryName, recipeList);
    }

    @Override
    public String toString() {
        return "RecipeCategory{" +
                "recipeCategoryId=" + recipeCategoryId +
                ", recipeCategoryName='" + recipeCategoryName + '\'' +
                ", recipeList=" + recipeList +
                '}';
    }
}


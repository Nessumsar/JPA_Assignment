package ec.utb.JPA_Assignment.Repository;

import ec.utb.JPA_Assignment.Entity.Recipe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

    List<Recipe> findRecipeByRecipeNameContains( String recipeName);

   List<Recipe> findRecipeByRecipeIngredients(String ingredientName);


    List<Recipe> findRecipeByRecipeCategories(String categoryName);

    @Query("SELECT recipe FROM Recipe recipe JOIN FETCH recipe.recipeCategories recipeCategory WHERE" +
            " recipeCategory.recipeCategoryName IN :categories")
    List<Recipe> findRecipesByCategoriesWithQuery(@Param("categories")List<String> categories);
}

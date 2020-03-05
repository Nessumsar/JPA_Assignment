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

    //Hitta alla recept som har en eller fleraträffar från en samling kategorier.  Ex: {”spicy”,”mexican”,”weekend”
    //kvar att göra

   // List<Recipe> findRecipeFromRecipeCategories(List<String> recipeCategories);


}

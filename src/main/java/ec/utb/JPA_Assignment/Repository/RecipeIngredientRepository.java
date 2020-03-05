package ec.utb.JPA_Assignment.Repository;

import ec.utb.JPA_Assignment.Entity.Ingredient;
import ec.utb.JPA_Assignment.Entity.RecipeIngredient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeIngredientRepository extends CrudRepository<RecipeIngredient, String> {



    List<Ingredient> findByIngredientIngredientNameContains(String ingredientName);

}

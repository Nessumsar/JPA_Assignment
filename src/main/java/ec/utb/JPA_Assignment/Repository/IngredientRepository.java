package ec.utb.JPA_Assignment.Repository;

import ec.utb.JPA_Assignment.Entity.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient,Integer> {

    Optional<Ingredient> findByIngredientName(String ingredientName);

    List<Ingredient>findByIngredientNameContainsIgnoreCase(String ingredientName);


}

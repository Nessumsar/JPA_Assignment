package ec.utb.JPA_Assignment.Repository;

import ec.utb.JPA_Assignment.Entity.Ingredient;
import ec.utb.JPA_Assignment.Entity.RecipeInstruction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeInstructionRepository extends CrudRepository<RecipeInstruction, Integer> {



}

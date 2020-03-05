package ec.utb.JPA_Assignment;

import ec.utb.JPA_Assignment.Entity.*;
import ec.utb.JPA_Assignment.Repository.IngredientRepository;
import ec.utb.JPA_Assignment.Repository.RecipeIngredientRepository;
import ec.utb.JPA_Assignment.Repository.RecipeInstructionRepository;
import ec.utb.JPA_Assignment.Repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

public class CommandLine implements CommandLineRunner {

    private RecipeRepository recipeRepository;
    private RecipeIngredientRepository recipeIngredientRepository;
    private RecipeInstructionRepository recipeInstructionRepository;
    private IngredientRepository ingredientRepository;


    @Autowired
    public CommandLine(RecipeRepository recipeRepository, RecipeIngredientRepository recipeIngredientRepository,
                       RecipeInstructionRepository recipeInstructionRepository,
                       IngredientRepository ingredientRepository) {
        this.recipeRepository = recipeRepository;
        this.recipeIngredientRepository = recipeIngredientRepository;
        this.recipeInstructionRepository = recipeInstructionRepository;
        this.ingredientRepository = ingredientRepository;
    }


    @Override
    @Transactional
    public void run(String... args) throws Exception {

        Recipe potatiskaka = new Recipe("Potatiskaka", null, null, null);

        RecipeIngredient milk = new RecipeIngredient(null, new Ingredient("Milk"), 3, Measurement.valueOf("DL"), potatiskaka);
        RecipeIngredient eggs = new RecipeIngredient(null, new Ingredient("Eggs"), 2, Measurement.valueOf("ST"), potatiskaka);
        RecipeIngredient sugar = new RecipeIngredient(null, new Ingredient("Sugar"), 2, Measurement.valueOf("DL"), potatiskaka);
        RecipeIngredient salt = new RecipeIngredient(null, new Ingredient("Salt"), 2, Measurement.valueOf("TSK"), potatiskaka);

        List<RecipeIngredient> potatiskakaIngredients = new ArrayList<>();
        potatiskakaIngredients.add(milk);
        potatiskakaIngredients.add(eggs);
        potatiskakaIngredients.add(sugar);
        potatiskakaIngredients.add(salt);
        potatiskaka.setRecipeIngredients(potatiskakaIngredients);

        RecipeInstruction potatiskakaInst = new RecipeInstruction("Instruktion");
        potatiskaka.setRecipeInstruction(potatiskakaInst);

        RecipeCategory easy = new RecipeCategory("Easy");
        RecipeCategory difficult = new RecipeCategory("Difficult");
        RecipeCategory slow = new RecipeCategory("Slow cooking");
        RecipeCategory fast = new RecipeCategory("Fast cooking");

        List<RecipeCategory> cookingCategories = new ArrayList<>();
        cookingCategories.add(easy);
        cookingCategories.add(slow);

        potatiskaka.setRecipeCategories(cookingCategories);
        recipeRepository.save(potatiskaka);

   List<RecipeCategory> cookingCategories2 = new ArrayList<>();
   cookingCategories2.add(difficult);
  cookingCategories2.add(fast);



    }



}

package ec.utb.JPA_Assignment.RepositoryTest;


import ec.utb.JPA_Assignment.Entity.Ingredient;
import ec.utb.JPA_Assignment.Entity.Recipe;
import ec.utb.JPA_Assignment.Entity.RecipeIngredient;
import ec.utb.JPA_Assignment.Repository.RecipeIngredientRepository;
import ec.utb.JPA_Assignment.Repository.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class RecipeRepoTest {
        //WIP

    @Autowired
    private RecipeRepository testObject;
    @Autowired
    private TestEntityManager em;
    @Autowired
    private Recipe testRecipe;

    private List<Recipe> data ()  {

        return Arrays.asList(new Recipe ("Gurka"),
                new Recipe("Tomat"));
    }


    @BeforeEach
    void setUp(){
        data().forEach(testObject::save);
        testRecipe = testObject.save(new Recipe("Gurka"));
        em.flush();
    }

    @Test
    void injectionsNotNull(){
        assertNotNull(testObject);
        assertNotNull(em);
    }


    @Test
    void testFindByRecipeNameContains(){
        String searchQuery = "r";
        List<Recipe> result = testObject.findRecipeByRecipeNameContains(searchQuery);

        assertEquals(2, result.size());
        assertTrue(result.contains(testRecipe));
    }
}

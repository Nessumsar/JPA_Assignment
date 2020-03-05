package ec.utb.JPA_Assignment.RepositoryTest;

import ec.utb.JPA_Assignment.Entity.Ingredient;
import ec.utb.JPA_Assignment.Repository.IngredientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;


@DataJpaTest
public class IngredientRepoTest {
    @Autowired
    private IngredientRepository testObject;

    Ingredient testBanana = new Ingredient("Banana");
    Ingredient testApple1 = new Ingredient("Red apple");
    Ingredient testApple2 = new Ingredient("Green apple");

    @BeforeEach
    void setUp(){
        testObject.save(testBanana);
        testObject.save(testApple1);
        testObject.save(testApple2);
    }

    @Test
    public void given_name_find_banana(){
        String name = "banana";
        Optional<Ingredient> result = testObject.findByIngredientName(name);

        assertTrue(result.isPresent());
        assertEquals(testBanana,result.get());
    }

    @Test
    public void given_name_contains_returns_2(){
        String name = "appl";
        List<Ingredient> result = testObject.findByIngredientNameContainsIgnoreCase(name);

        assertEquals(2,result.size());
    }

}

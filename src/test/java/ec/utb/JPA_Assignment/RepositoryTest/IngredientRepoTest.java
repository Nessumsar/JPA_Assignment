package ec.utb.JPA_Assignment.RepositoryTest;

import ec.utb.JPA_Assignment.Entity.Ingredient;
import ec.utb.JPA_Assignment.Repository.IngredientRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.*;
import org.springframework.test.context.TestPropertySource;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;


@DataJpaTest
@TestPropertySource(locations="classpath:resources.properties")
public class IngredientRepoTest {

    @Autowired private IngredientRepository testObject;
    @Autowired private TestEntityManager em;

    private List<Ingredient> data ()  {
        return Arrays.asList(new Ingredient ("Paprika"),
                new Ingredient("Tomat")
        );
    }

    private Ingredient testIngredient;

    @BeforeEach
    void setUp(){
        data().forEach(testObject::save);
        testIngredient = testObject.save(new Ingredient("Gurka"));
        em.flush();
    }

    @Test
    void injectionsNotNull(){
        assertNotNull(testObject);
        assertNotNull(em);
    }

    @Test
    void testFindByIngredientName(){
        String name = "Gurka";
        Optional<Ingredient> result = testObject.findByIngredientName(name);

        assertTrue(result.isPresent());
        assertEquals(testIngredient, result.get());
    }

    @Test
    void testFindByIngredientNameContains(){
        String searchQuery = "r";
        List<Ingredient> result = testObject.findByIngredientNameContainsIgnoreCase(searchQuery);

        assertEquals(2, result.size());
        assertTrue(result.contains(testIngredient));
    }
}

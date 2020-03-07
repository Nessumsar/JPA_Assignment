package ec.utb.JPA_Assignment.RepositoryTest;


import ec.utb.JPA_Assignment.Entity.Ingredient;
import ec.utb.JPA_Assignment.Entity.RecipeIngredient;
import ec.utb.JPA_Assignment.Repository.IngredientRepository;
import ec.utb.JPA_Assignment.Repository.RecipeIngredientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class RecipeIngredientRepoTest {

}

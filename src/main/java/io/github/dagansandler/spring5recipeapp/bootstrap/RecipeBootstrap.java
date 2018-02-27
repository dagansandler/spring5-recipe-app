package io.github.dagansandler.spring5recipeapp.bootstrap;

import io.github.dagansandler.spring5recipeapp.domain.Difficulty;
import io.github.dagansandler.spring5recipeapp.domain.Ingredient;
import io.github.dagansandler.spring5recipeapp.domain.Recipe;
import io.github.dagansandler.spring5recipeapp.repositories.RecipeRepository;
import io.github.dagansandler.spring5recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {


    private RecipeRepository recipeRepository;

    private UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootstrap(RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Recipe guacamoleRecipe = new Recipe();
        guacamoleRecipe.setDescription("Perfect Guacamole");

        Ingredient avocados = new Ingredient();
        avocados.setDescription("Ripe Avocados");
        avocados.setAmount(new BigDecimal(2));
        avocados.setUom(unitOfMeasureRepository.findByDescription("Unit")
                .orElseThrow(() -> new IllegalArgumentException("Unit")));
        avocados.setRecipe(guacamoleRecipe);

        Set<Ingredient> guacamoleIngredients = new HashSet<>();
        guacamoleIngredients.add(avocados);
        guacamoleRecipe.setIngredients(guacamoleIngredients);

        guacamoleRecipe.setServings(3);
        guacamoleRecipe.setDifficulty(Difficulty.EASY);
        guacamoleRecipe.setPrepTime(10);
        guacamoleRecipe.setCookTime(0);
        guacamoleRecipe.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
        guacamoleRecipe.setDirections("1 Cut avocado, remove flesh: Cut the avocados in half. " +
                "Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. " +
                "(See How to Cut and Peel an Avocado.) Place in a bowl.\n" +
                "\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado." +
                " (Don't overdo it! The guacamole should be a little chunky.)\n" +
                "\n" +
                "3 Add salt, lime juice, and the rest: " +
                "Sprinkle with salt and lime (or lemon) juice. " +
                "The acid in the lime juice will provide some balance to the richness of the avocado" +
                " and will help delay the avocados from turning brown.\n" +
                "\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. " +
                "Chili peppers vary individually in their hotness. " +
                "So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness." +
                "\n" +
                "\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. " +
                "Start with this recipe and adjust to your taste.\n" +
                "\n" +
                "4 Cover with plastic and chill to store: " +
                "Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. " +
                "(The oxygen in the air causes oxidation which will turn the guacamole brown.) " +
                "Refrigerate until ready to serve.\n" +
                "\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, " +
                "add it just before serving.\n" +
                "\n");
        recipeRepository.save(guacamoleRecipe);


    }
}

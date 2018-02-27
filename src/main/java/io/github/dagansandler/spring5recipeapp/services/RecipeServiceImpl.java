package io.github.dagansandler.spring5recipeapp.services;

import io.github.dagansandler.spring5recipeapp.domain.Recipe;
import io.github.dagansandler.spring5recipeapp.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

@Service
public class RecipeServiceImpl implements RecipeService {

    private RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Iterable<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }
}

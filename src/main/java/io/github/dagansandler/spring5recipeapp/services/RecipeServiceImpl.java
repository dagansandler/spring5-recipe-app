package io.github.dagansandler.spring5recipeapp.services;

import io.github.dagansandler.spring5recipeapp.domain.Recipe;
import io.github.dagansandler.spring5recipeapp.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService {

    private RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getAllRecipes() {
        return new HashSet<>((Collection<? extends Recipe>) recipeRepository.findAll());
    }
}

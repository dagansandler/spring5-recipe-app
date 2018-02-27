package io.github.dagansandler.spring5recipeapp.services;

import io.github.dagansandler.spring5recipeapp.domain.Recipe;

public interface RecipeService {

    Iterable<Recipe> getAllRecipes();

}

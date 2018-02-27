package io.github.dagansandler.spring5recipeapp.services;

import io.github.dagansandler.spring5recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getAllRecipes();

}

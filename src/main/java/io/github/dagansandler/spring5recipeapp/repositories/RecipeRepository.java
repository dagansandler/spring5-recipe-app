package io.github.dagansandler.spring5recipeapp.repositories;

import io.github.dagansandler.spring5recipeapp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {


}

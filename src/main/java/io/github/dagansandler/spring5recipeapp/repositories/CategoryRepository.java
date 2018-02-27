package io.github.dagansandler.spring5recipeapp.repositories;

import io.github.dagansandler.spring5recipeapp.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}

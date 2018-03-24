package io.github.dagansandler.spring5recipeapp.repositories;

import io.github.dagansandler.spring5recipeapp.domain.UnitOfMeasure;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT {

    @Autowired
    private UnitOfMeasureRepository unitOfMeasureRepository;

    @Test
    public void findByDescription() {
        String teaspoonDescription = "Teaspoon";
        Optional<UnitOfMeasure> teaSpoonOptional = unitOfMeasureRepository.findByDescription(teaspoonDescription);

        assertTrue("UnitOfMeasureRepository returned an empty Optional!", teaSpoonOptional.isPresent());
        assertEquals(teaspoonDescription, teaSpoonOptional.get().getDescription());
    }

    @Test
    public void findByDescriptionCup() {
        String cupDescription = "Cup";
        Optional<UnitOfMeasure> cupOptional = unitOfMeasureRepository.findByDescription(cupDescription);

        assertTrue("UnitOfMeasureRepository returned an empty Optional!", cupOptional.isPresent());
        assertEquals(cupDescription, cupOptional.get().getDescription());
    }

}
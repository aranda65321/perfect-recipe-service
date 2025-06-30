package com.co.perfectrecipe.manager.module.recipe.usecase.impl;

import com.co.perfectrecipe.manager.crosscutting.domain.dto.RecipeDto;
import com.co.perfectrecipe.manager.crosscutting.domain.entity.RecipeEntity;
import com.co.perfectrecipe.manager.module.recipe.dataprovider.RecipeDataProvider;
import com.co.perfectrecipe.manager.module.recipe.usecase.RecipeUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@Log4j2
@AllArgsConstructor
public class RecipeUseCaseImpl implements RecipeUseCase {

    private final RecipeDataProvider recipeDataProvider;


    @Override
    public RecipeEntity findById(UUID id) {
        return this.recipeDataProvider.findById(id);
    }

    @Override
    public RecipeEntity save(RecipeEntity recipe) {
        return this.recipeDataProvider.save(recipe);
    }

    @Override
    public RecipeEntity update(RecipeDto recipe) {
        RecipeEntity recipeSaved = this.recipeDataProvider.findById(recipe.getId());
        recipeSaved.setName(recipe.getName());
        recipeSaved.setNote(recipe.getNote());
        recipeSaved.setDescription(recipe.getDescription());
        recipeSaved.setCookingTime(recipe.getCookingTime());
        recipeSaved.setPrepTime(recipe.getPrepTime());
        recipeSaved.setServings(recipe.getServings());
        recipeSaved.setTypeCuisine(recipe.getTypeCuisine());
        return this.save(recipeSaved);
    }

    @Override
    public void delete(UUID recipeId) {
        this.recipeDataProvider.delete(recipeId);
    }

    @Override
    public List<RecipeEntity> findAll() {
        return this.recipeDataProvider.findAll();
    }

    @Override
    public List<RecipeEntity> findByPagination(Pageable pagination) {
        return null;
    }
}

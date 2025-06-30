package com.co.perfectrecipe.manager.module.recipe.dataprovider.impl;

import com.co.perfectrecipe.manager.crosscutting.domain.entity.RecipeEntity;
import com.co.perfectrecipe.manager.crosscutting.domain.repository.RecipeRepository;
import com.co.perfectrecipe.manager.module.recipe.dataprovider.RecipeDataProvider;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class RecipeDataProviderImpl implements RecipeDataProvider {

    private final RecipeRepository recipeRepository;

    @Override
    public RecipeEntity findById(UUID id) {
        return this.recipeRepository.findById(id).orElse(null);
    }

    @Override
    public RecipeEntity save(RecipeEntity recipe) {
        return this.recipeRepository.save(recipe);
    }

    @Override
    public RecipeEntity update(RecipeEntity recipe) {
        return this.save(recipe);
    }

    @Override
    public void delete(UUID recipeId) {
        this.recipeRepository.deleteById(recipeId);
    }

    @Override
    public List<RecipeEntity> findAll() {
        return this.recipeRepository.findAll();
    }

    @Override
    public List<RecipeEntity> findByPagination(Pageable pagination) {
        return null;
    }
}

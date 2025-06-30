package com.co.perfectrecipe.manager.module.recipe.usecase;

import com.co.perfectrecipe.manager.crosscutting.domain.entity.RecipeIngredientEntity;

import java.util.List;
import java.util.UUID;

public interface RecipeIngredientUseCase {
    public List<RecipeIngredientEntity> findByRecipeId(UUID recipeId);

    public List<RecipeIngredientEntity> saveAll(List<RecipeIngredientEntity> ingredients);
}

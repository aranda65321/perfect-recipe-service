package com.co.perfectrecipe.manager.module.recipe.dataprovider;

import com.co.perfectrecipe.manager.crosscutting.domain.entity.RecipeIngredientEntity;

import java.util.List;
import java.util.UUID;

public interface RecipeIngredientDataProvider {

    public List<RecipeIngredientEntity> findByRecipeId(UUID recipeId);

    public List<RecipeIngredientEntity> saveAll(List<RecipeIngredientEntity> ingredients);
}

package com.co.perfectrecipe.manager.module.recipe.usecase.impl;

import com.co.perfectrecipe.manager.crosscutting.domain.entity.RecipeIngredientEntity;
import com.co.perfectrecipe.manager.module.recipe.dataprovider.RecipeIngredientDataProvider;
import com.co.perfectrecipe.manager.module.recipe.usecase.RecipeIngredientUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class RecipeIngredientUseCaseImpl implements RecipeIngredientUseCase {

    private final RecipeIngredientDataProvider recipeIngredientDataProvider;

    @Override
    public List<RecipeIngredientEntity> findByRecipeId(UUID recipeId) {
        return this.recipeIngredientDataProvider.findByRecipeId(recipeId);
    }

    @Override
    public List<RecipeIngredientEntity> saveAll(List<RecipeIngredientEntity> ingredients) {
        return this.recipeIngredientDataProvider.saveAll(ingredients);
    }
}

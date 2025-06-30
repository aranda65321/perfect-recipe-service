package com.co.perfectrecipe.manager.module.recipe.dataprovider.impl;

import com.co.perfectrecipe.manager.crosscutting.domain.entity.RecipeIngredientEntity;
import com.co.perfectrecipe.manager.crosscutting.domain.repository.RecipeIngredientRepository;
import com.co.perfectrecipe.manager.module.recipe.dataprovider.RecipeIngredientDataProvider;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class RecipeIngredientDataProviderImpl implements RecipeIngredientDataProvider {

    private final RecipeIngredientRepository recipeIngredientRepository;

    @Override
    public List<RecipeIngredientEntity> findByRecipeId(UUID recipeId) {
        return this.recipeIngredientRepository.findByRecipe_Id(recipeId);
    }

    @Override
    public List<RecipeIngredientEntity> saveAll(List<RecipeIngredientEntity> ingredients) {
        return this.recipeIngredientRepository.saveAll(ingredients);
    }
}

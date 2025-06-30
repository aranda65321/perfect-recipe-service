package com.co.perfectrecipe.manager.crosscutting.domain.translators;

import com.co.perfectrecipe.manager.crosscutting.domain.dto.RecipeIngredientDto;
import com.co.perfectrecipe.manager.crosscutting.domain.entity.RecipeEntity;
import com.co.perfectrecipe.manager.crosscutting.domain.entity.RecipeIngredientEntity;

import java.util.ArrayList;
import java.util.List;

public class RecipeIngredientTranslator {


    public static List<RecipeIngredientEntity> toListRecipeIngredientEntity(RecipeEntity recipe, List<RecipeIngredientDto> ingredients) {
        List<RecipeIngredientEntity> ingredientsEntity = new ArrayList();
        if (ingredients != null && !ingredients.isEmpty()) {
            ingredients.forEach(ingredient -> ingredientsEntity.add(toRecipeIngredient(recipe, ingredient)));
        }
        return ingredientsEntity;
    }

    public static RecipeIngredientEntity toRecipeIngredient(RecipeEntity recipe, RecipeIngredientDto ingredient) {
        return RecipeIngredientEntity.builder()
                .recipe(recipe)
                .description(ingredient.getDescription())
                .build();
    }

    public static List<RecipeIngredientDto> toListRecipeIngredientDto(RecipeEntity recipe) {
        List<RecipeIngredientDto> recipeIngredientDtos = new ArrayList();
        if (recipe.getIngredients() != null && !recipe.getIngredients().isEmpty()) {
            recipe.getIngredients().forEach(ingredient -> recipeIngredientDtos.add(toRecipeIngredientDto(recipe, ingredient)));
        }
        return recipeIngredientDtos;
    }

    public static RecipeIngredientDto toRecipeIngredientDto(RecipeEntity recipe, RecipeIngredientEntity ingredient) {
        return RecipeIngredientDto.builder()
                .id(ingredient.getId())
                .recipeId(recipe.getId())
                .description(ingredient.getDescription())
                .build();
    }
}

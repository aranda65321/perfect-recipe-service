package com.co.perfectrecipe.manager.crosscutting.domain.translators;

import com.co.perfectrecipe.manager.crosscutting.domain.dto.RecipeDto;
import com.co.perfectrecipe.manager.crosscutting.domain.entity.RecipeEntity;

import java.util.ArrayList;
import java.util.List;

public class RecipeTranslator {

    public static List<RecipeDto> toListRecipeDto(List<RecipeEntity> recipesEntity) {
        List<RecipeDto> recipes = new ArrayList<>();
        recipesEntity.forEach(recipe -> recipes.add(toRecipeDto(recipe)));
        return recipes;
    }

    public static RecipeDto toRecipeDto(RecipeEntity recipe) {
        return RecipeDto.builder()
                .cookingTime(recipe.getCookingTime())
                .creationDate(recipe.getCreationDate())
                .description(recipe.getDescription())
                .id(recipe.getId())
                .name(recipe.getName())
                .note(recipe.getNote())
                .prepTime(recipe.getPrepTime())
                .servings(recipe.getServings())
                .typeCuisine(recipe.getTypeCuisine())
                .build();
    }


    public static RecipeEntity toRecipeEntity(RecipeDto recipe) {
        return RecipeEntity.builder()
                .id(recipe.getId())
                .cookingTime(recipe.getCookingTime())
                .creationDate(recipe.getCreationDate())
                .description(recipe.getDescription())
                .name(recipe.getName())
                .note(recipe.getNote())
                .prepTime(recipe.getPrepTime())
                .servings(recipe.getServings())
                .typeCuisine(recipe.getTypeCuisine())
                .build();
    }
}

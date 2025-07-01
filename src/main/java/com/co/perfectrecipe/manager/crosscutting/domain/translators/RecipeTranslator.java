package com.co.perfectrecipe.manager.crosscutting.domain.translators;

import com.co.perfectrecipe.manager.crosscutting.domain.dto.RecipeDto;
import com.co.perfectrecipe.manager.crosscutting.domain.entity.RecipeEntity;
import com.co.perfectrecipe.manager.crosscutting.utils.FileUtils;

import java.time.LocalDateTime;
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
                .creationDate(LocalDateTime.now().toString())
                .description(recipe.getDescription())
                .id(recipe.getId())
                .name(recipe.getName())
                .note(recipe.getNote())
                .prepTime(recipe.getPrepTime())
                .servings(recipe.getServings())
                .typeCuisine(recipe.getTypeCuisine())
                .author(recipe.getAuthor())
                .calories(recipe.getCalories())
                .visits(recipe.getVisits())
                .img(FileUtils.encodeImageToBase64DataUrl(recipe.getImg(), "image/png"))
                .ingredients(RecipeIngredientTranslator.toListRecipeIngredientDto(recipe))
                .instructions(RecipeInstructionTranslator.toListRecipeInstructionDto(recipe))
                .build();
    }


    public static RecipeEntity toRecipeEntity(RecipeDto recipe) {
        RecipeEntity recipeEntity = RecipeEntity.builder()
                .id(recipe.getId())
                .cookingTime(recipe.getCookingTime())
                .creationDate(LocalDateTime.now())
                .description(recipe.getDescription())
                .name(recipe.getName())
                .note(recipe.getNote())
                .prepTime(recipe.getPrepTime())
                .servings(recipe.getServings())
                .typeCuisine(recipe.getTypeCuisine())
                .author(recipe.getAuthor())
                .calories(recipe.getCalories())
                .visits(recipe.getVisits())
                .img(recipe.getImg())
                .build();
        recipeEntity.setIngredients(RecipeIngredientTranslator.toListRecipeIngredientEntity(recipeEntity, recipe.getIngredients()));
        recipeEntity.setInstructions(RecipeInstructionTranslator.toListRecipeIngredientEntity(recipeEntity, recipe.getInstructions()));
        return recipeEntity;
    }
}

package com.co.perfectrecipe.manager.crosscutting.domain.translators;

import com.co.perfectrecipe.manager.crosscutting.domain.dto.RecipeInstructionsDto;
import com.co.perfectrecipe.manager.crosscutting.domain.entity.RecipeEntity;
import com.co.perfectrecipe.manager.crosscutting.domain.entity.RecipeInstructionEntity;

import java.util.ArrayList;
import java.util.List;

public class RecipeInstructionTranslator {

    public static List<RecipeInstructionEntity> toListRecipeIngredientEntity(RecipeEntity recipe, List<RecipeInstructionsDto> instructionsDto) {
        List<RecipeInstructionEntity> instructions = new ArrayList();
        if (instructionsDto != null && !instructionsDto.isEmpty()) {
            instructionsDto.forEach(ingredient -> instructions.add(toRecipeInstruction(recipe, ingredient)));
        }
        return instructions;
    }

    public static RecipeInstructionEntity toRecipeInstruction(RecipeEntity recipe, RecipeInstructionsDto instruction) {
        return RecipeInstructionEntity.builder()
                .id(instruction.getId())
                .recipe(recipe)
                .step(instruction.getStep())
                .description(instruction.getDescription())
                .build();
    }

    public static List<RecipeInstructionsDto> toListRecipeInstructionDto(RecipeEntity recipe) {
        List<RecipeInstructionsDto> recipeIngredientDtos = new ArrayList();
        if (recipe.getInstructions() != null && !recipe.getInstructions().isEmpty()) {
            recipe.getInstructions().forEach(ingredient -> recipeIngredientDtos.add(toRecipeIngredientDto(recipe, ingredient)));
        }
        return recipeIngredientDtos;
    }

    public static RecipeInstructionsDto toRecipeIngredientDto(RecipeEntity recipe, RecipeInstructionEntity instruction) {
        return RecipeInstructionsDto.builder()
                .id(instruction.getId())
                .step(instruction.getStep())
                .recipeId(recipe.getId())
                .description(instruction.getDescription())
                .build();
    }
}

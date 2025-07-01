package com.co.perfectrecipe.manager.crosscutting.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecipeDto {
    private UUID id;
    private String name;
    private String description;
    private String note;
    private String creationDate;
    private String servings;
    private String cookingTime;
    private String prepTime;
    private String typeCuisine;
    private List<RecipeInstructionsDto> instructions;
    private List<RecipeIngredientDto> ingredients;
    private String author;
    private Integer calories;
    private Integer visits;
    private String img;
}

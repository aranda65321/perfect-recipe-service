package com.co.perfectrecipe.manager.crosscutting.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecipeInstructionsDto {
    private UUID id;
    private UUID recipeId;
    private String description;
    private Float step;
}

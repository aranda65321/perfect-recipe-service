package com.co.perfectrecipe.manager.crosscutting.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
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
    private LocalDateTime creationDate;
    private String servings;
    private String cookingTime;
    private String prepTime;
    private String typeCuisine;
    private List<String> instructions;
    private List<String> ingredients;
}

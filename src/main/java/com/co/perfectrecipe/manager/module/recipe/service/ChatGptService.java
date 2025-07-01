package com.co.perfectrecipe.manager.module.recipe.service;

import com.co.perfectrecipe.manager.crosscutting.domain.dto.RecipeDto;
import com.co.perfectrecipe.manager.crosscutting.exception.ApiProcessException;

public interface ChatGptService {
    public RecipeDto generateRecipe() throws ApiProcessException;
}

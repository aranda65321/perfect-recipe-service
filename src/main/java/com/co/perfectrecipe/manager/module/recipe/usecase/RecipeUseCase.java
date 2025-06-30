package com.co.perfectrecipe.manager.module.recipe.usecase;

import com.co.perfectrecipe.manager.crosscutting.domain.dto.RecipeDto;
import com.co.perfectrecipe.manager.crosscutting.domain.entity.RecipeEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface RecipeUseCase {
    public RecipeEntity findById(UUID id);

    public RecipeEntity save(RecipeEntity recipe);

    public RecipeEntity update(RecipeDto recipe);

    public void delete(UUID recipeId);

    public List<RecipeEntity> findAll();

    public List<RecipeEntity> findByPagination(Pageable pagination);

}

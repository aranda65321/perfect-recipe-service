package com.co.perfectrecipe.manager.module.recipe.service;

import com.co.perfectrecipe.manager.crosscutting.domain.dto.ApiResponseDto;
import com.co.perfectrecipe.manager.crosscutting.domain.dto.RecipeDto;
import com.co.perfectrecipe.manager.crosscutting.domain.entity.RecipeEntity;
import com.co.perfectrecipe.manager.crosscutting.exception.ApiProcessException;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface RecipeService {
    public ResponseEntity<ApiResponseDto> findById(UUID id) throws ApiProcessException;

    public ResponseEntity<ApiResponseDto> save(RecipeDto recipe) throws ApiProcessException;

    public ResponseEntity<ApiResponseDto> generateRecipe() throws ApiProcessException;

    public ResponseEntity<ApiResponseDto> update(RecipeDto recipe) throws ApiProcessException;

    public void delete(UUID recipeId) throws ApiProcessException;

    public ResponseEntity<ApiResponseDto> findAll() throws ApiProcessException;

    public ResponseEntity<ApiResponseDto> findByPagination(Pageable pagination);
}

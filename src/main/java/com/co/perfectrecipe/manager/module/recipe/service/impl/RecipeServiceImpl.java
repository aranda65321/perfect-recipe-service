package com.co.perfectrecipe.manager.module.recipe.service.impl;

import com.co.perfectrecipe.manager.crosscutting.domain.dto.ApiResponseDto;
import com.co.perfectrecipe.manager.crosscutting.domain.dto.RecipeDto;
import com.co.perfectrecipe.manager.crosscutting.domain.enums.TypeError;
import com.co.perfectrecipe.manager.crosscutting.domain.translators.ApiResponseTranslator;
import com.co.perfectrecipe.manager.crosscutting.domain.translators.RecipeTranslator;
import com.co.perfectrecipe.manager.crosscutting.exception.ApiProcessException;
import com.co.perfectrecipe.manager.module.recipe.service.RecipeService;
import com.co.perfectrecipe.manager.module.recipe.usecase.RecipeUseCase;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final RecipeUseCase recipeUseCase;

    @Override
    public ResponseEntity<ApiResponseDto> findById(UUID id) throws ApiProcessException {
        try {
            return ResponseEntity.ok(ApiResponseTranslator.toApiResponseDto(HttpStatus.OK,
                    RecipeTranslator.toRecipeDto(this.recipeUseCase.findById(id))));
        } catch (Exception ex) {
            throw new ApiProcessException(ex, TypeError.IR_001);
        }
    }

    @Override
    public ResponseEntity<ApiResponseDto> save(RecipeDto recipe) throws ApiProcessException {
        try {
            return ResponseEntity.ok(ApiResponseTranslator.toApiResponseDto(HttpStatus.OK,
                    RecipeTranslator.toRecipeDto(this.recipeUseCase.save(RecipeTranslator.toRecipeEntity(recipe)))));
        } catch (Exception ex) {
            throw new ApiProcessException(ex, TypeError.IR_002);
        }
    }

    @Override
    public ResponseEntity<ApiResponseDto> update(RecipeDto recipe) throws ApiProcessException {
        try {
            return ResponseEntity.ok(ApiResponseTranslator.toApiResponseDto(HttpStatus.OK,
                    RecipeTranslator.toRecipeDto(this.recipeUseCase.update(recipe))));
        } catch (Exception ex) {
            throw new ApiProcessException(ex, TypeError.IR_003);
        }
    }

    @Override
    public void delete(UUID recipeId) throws ApiProcessException {
        try {
            this.recipeUseCase.delete(recipeId);
        } catch (Exception ex) {
            throw new ApiProcessException(ex, TypeError.IR_004);
        }
    }

    @Override
    public ResponseEntity<ApiResponseDto> findAll() throws ApiProcessException {
        try {
            return ResponseEntity.ok(ApiResponseTranslator.toApiResponseDto(HttpStatus.OK,
                    RecipeTranslator.toListRecipeDto(this.recipeUseCase.findAll())));
        } catch (Exception ex) {
            throw new ApiProcessException(ex, TypeError.IR_004);
        }
    }

    @Override
    public ResponseEntity<ApiResponseDto> findByPagination(Pageable pagination) {
        return new ResponseEntity(HttpStatus.OK);
    }
}

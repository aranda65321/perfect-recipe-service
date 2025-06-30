package com.co.perfectrecipe.manager.module.recipe.api;

import com.co.perfectrecipe.manager.crosscutting.domain.dto.ApiResponseDto;
import com.co.perfectrecipe.manager.crosscutting.domain.dto.RecipeDto;
import com.co.perfectrecipe.manager.crosscutting.exception.ApiProcessException;
import com.co.perfectrecipe.manager.module.recipe.service.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/recipe")
@CrossOrigin("*")
@AllArgsConstructor
public class RecipeController {
    private final RecipeService recipeService;

    @GetMapping("/findById")
    public ResponseEntity<ApiResponseDto> findById(UUID id) throws ApiProcessException {
        return this.recipeService.findById(id);
    }

    @PostMapping
    public ResponseEntity<ApiResponseDto> save(@RequestBody RecipeDto recipe) throws ApiProcessException {
        return this.recipeService.save(recipe);
    }

    @PutMapping
    public ResponseEntity<ApiResponseDto> update(@RequestBody RecipeDto recipe) throws ApiProcessException {
        return this.recipeService.update(recipe);
    }

    @DeleteMapping
    public void delete(@RequestParam UUID recipeId) throws ApiProcessException {
        this.recipeService.delete(recipeId);
    }

    @GetMapping
    public ResponseEntity<ApiResponseDto> findAll() throws ApiProcessException {
        return this.recipeService.findAll();
    }

    @GetMapping("/pagination")
    public ResponseEntity<ApiResponseDto> findByPagination(@RequestParam Integer page, @RequestParam Integer size) {
        return this.recipeService.findByPagination(PageRequest.of(page, size));
    }

}

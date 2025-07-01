package com.co.perfectrecipe.manager.module.recipe.api;

import com.co.perfectrecipe.manager.crosscutting.domain.dto.ApiResponseDto;
import com.co.perfectrecipe.manager.crosscutting.domain.dto.RecipeDto;
import com.co.perfectrecipe.manager.crosscutting.exception.ApiProcessException;
import com.co.perfectrecipe.manager.crosscutting.utils.FileUtils;
import com.co.perfectrecipe.manager.module.recipe.service.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/recipe")
@CrossOrigin("*")
@AllArgsConstructor
public class RecipeController {
    private final RecipeService recipeService;
    private final Environment environment;
    private static final String IMG_FORMAT = ".png";

    @GetMapping("/findById")
    public ResponseEntity<ApiResponseDto> findById(@RequestParam UUID id) throws ApiProcessException {
        return this.recipeService.findById(id);
    }

    @PostMapping
    public ResponseEntity<ApiResponseDto> save(@RequestPart("recipe") RecipeDto recipe, @RequestPart("file") MultipartFile file) throws ApiProcessException, IOException {
        recipe.setImg(FileUtils.saveFile(this.environment.getRequiredProperty("files.default-path-images")
                .concat(UUID.randomUUID().toString()).concat(IMG_FORMAT), file.getBytes()));
        return this.recipeService.save(recipe);
    }

    @PutMapping
    public ResponseEntity<ApiResponseDto> update(@RequestPart("recipe") RecipeDto recipe, @RequestPart("file") MultipartFile file) throws ApiProcessException, IOException {
        recipe.setImg(FileUtils.saveFile(this.environment.getRequiredProperty("files.default-path-images")
                .concat(UUID.randomUUID().toString()).concat(IMG_FORMAT), file.getBytes()));
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

    @PostMapping("/generate")
    public ResponseEntity<ApiResponseDto> generateRecipe() throws ApiProcessException {
        return this.recipeService.generateRecipe();
    }

}

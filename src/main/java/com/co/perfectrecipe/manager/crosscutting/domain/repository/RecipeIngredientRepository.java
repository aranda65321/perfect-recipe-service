package com.co.perfectrecipe.manager.crosscutting.domain.repository;

import com.co.perfectrecipe.manager.crosscutting.domain.entity.RecipeIngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredientEntity, UUID> {

    public List<RecipeIngredientEntity> findByRecipe_Id(UUID id);
}

package com.co.perfectrecipe.manager.crosscutting.domain.repository;

import com.co.perfectrecipe.manager.crosscutting.domain.entity.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RecipeRepository extends JpaRepository<RecipeEntity, UUID> {
}

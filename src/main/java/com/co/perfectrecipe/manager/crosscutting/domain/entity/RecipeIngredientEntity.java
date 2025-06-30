package com.co.perfectrecipe.manager.crosscutting.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
@Table(schema = "PERFECT_RECIPE_DOMAIN", name = "recipe_ingredient")
public class RecipeIngredientEntity {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "fk_recipe", foreignKey = @ForeignKey(name = "fk_recipe"))
    private RecipeEntity recipe;

    private String description;
}

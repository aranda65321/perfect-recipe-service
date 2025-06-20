package com.co.perfectrecipe.manager.crosscutting.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
@Table(schema = "PERFECT_RECIPE_DOMAIN", name = "recipe")
public class RecipeEntity {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private UUID id;
    private String name;
    private String description;
    private String note;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    private String servings;

    @Column(name = "cooking_time")
    private String cookingTime;

    @Column(name = "prep_time")
    private String prepTime;

    @Column(name = "type_cusine")
    private String typeCuisine;

}

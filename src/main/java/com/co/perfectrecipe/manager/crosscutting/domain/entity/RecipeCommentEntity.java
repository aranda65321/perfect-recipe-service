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
@Table(schema = "PERFECT_RECIPE_DOMAIN", name = "recipe_comment")
public class RecipeCommentEntity {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "fk_recipe", nullable = true)
    private RecipeEntity recipe;

    private String description;

    private Float reviews;

    private String author;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;
}

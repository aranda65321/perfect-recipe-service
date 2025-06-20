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
@Table(schema = "PERFECT_RECIPE_DOMAIN", name = "input_blog")
public class InputBlogEntity {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private UUID id;
    private String name;
    @Column(name = "creation_date")
    private LocalDateTime creationDate;
}

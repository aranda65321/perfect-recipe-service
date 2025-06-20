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
@Table(schema = "PERFECT_RECIPE_DOMAIN", name = "paragraph_blog")
public class ParagraphBlogEntity {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "fk_input_blog", nullable = true)
    private InputBlogEntity inputBlog;
    private String description;
}

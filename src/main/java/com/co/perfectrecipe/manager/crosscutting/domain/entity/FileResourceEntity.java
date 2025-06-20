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
@Table(schema = "PERFECT_RECIPE_DOMAIN", name = "file_resource")
public class FileResourceEntity {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private UUID id;

    @Column(name = "fk_parent")
    private UUID parentId;
    private String path;
    private String type;
    private Float size;
    private String filename;
    @Column(name = "creation_date")
    private LocalDateTime creationDate;
}

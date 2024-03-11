package com.example.ingame365.domain.entities.training;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;



@Entity
@Table(name = "after_training")
@Data
public class AfterTraining {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Column(name = "training_id")
    private Long trainingId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "difficulty")
    private Short difficulty;

    @Column(name = "comments")
    private String comments;

}

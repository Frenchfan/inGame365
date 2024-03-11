package com.example.ingame365.domain.entities.training;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "before_training")
@Data
public class BeforeTraining {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Column(name = "training_id")
    @Schema(description = "Training id")
    private Long trainingId;

    @Column(name = "user_id")
    @Schema(description = "User id")
    private Long userId;

    @Column(name = "front_right_hip")
    @Schema(description = "Правая передняя поверхность бедра")
    private short frontRightHip;

    @Column(name = "front_left_hip")
    @Schema(description = "Левая передняя поверхность бедра")
    private short frontLeftHip;

    @Column(name = "rear_right_hip")
    @Schema(description = "Правая задняя поверхность бедра")
    private short rearRightHip;

    @Column(name = "rear_left_hip")
    @Schema(description = "Левая задняя поверхность бедра")
    private short rearLeftHip;

    @Column(name = "right_adductor")
    @Schema(description = "Правая приводящая мышца")
    private short rightAdductor;

    @Column(name = "left_adductor")
    @Schema(description = "Левая приводящая мышца")
    private short leftAdductor;

    @Column(name = "right_groin")
    @Schema(description = "Правая паховая область")
    private short rightGroin;

    @Column(name = "left_groin")
    @Schema(description = "Левая паховая область")
    private short leftGroin;

    @Column(name = "right_calf")
    @Schema(description = "Правая икра")
    private short rightCalf;

    @Column(name = "left_calf")
    @Schema(description = "Левая икра")
    private short leftCalf;

    @Column(name = "fatigue")
    @Schema(description = "Усталость")
    private short fatigue;

    @Column(name = "dream_quality")
    @Schema(description = "Качество сна")
    private short dreamQuality;

    @Column(name = "muscle_pain")
    @Schema(description = "Боль в мышцах")
    private short musclePain;

    @Column(name = "stress")
    @Schema(description = "Стресс")
    private short stress;

    @Column(name = "comments")
    @Schema(description = "Комментарии")
    private String comments;

}

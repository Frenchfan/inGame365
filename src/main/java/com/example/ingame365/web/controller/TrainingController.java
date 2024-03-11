package com.example.ingame365.web.controller;

import com.example.ingame365.domain.entities.training.AfterTraining;
import com.example.ingame365.domain.entities.training.BeforeTraining;
import com.example.ingame365.domain.entities.training.Training;
import com.example.ingame365.service.TrainingService;
import com.example.ingame365.web.dto.training.TrainingDto;
import com.example.ingame365.web.dto.training.TrainingPostDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "Training Controller", description = "Training API")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/training")
public class TrainingController {

    private final TrainingService trainingService;

    @GetMapping("/user/{id}")
    @Operation(summary = "Get all trainings by user id")
    @PreAuthorize("@customSecurityExpression.canAccessUser(#id)")
    public List<TrainingDto> getTrainingsByUserId(@PathVariable Long id) {
        return trainingService.getAllTrainingsByUserId(id);
    }

    @PostMapping
    @Operation(summary = "Create training")
    public Training create(@RequestBody Training training) {
        return trainingService.save(training);
    }

    @GetMapping("/{id}/before")
    @Operation(summary = "Get all before_training impressions by training_id")
    public List<BeforeTraining> getBeforeTrainingsByTrainingId(@PathVariable Long id) {
        return trainingService.getAllBeforeTrainingByTrainingId(id);
    }

    @PostMapping("/{id}/before")
    @Operation(summary = "Create before_training impression")
    public BeforeTraining createBeforeTraining(@PathVariable Long id, @RequestBody BeforeTraining beforeTraining) {
        return trainingService.save(beforeTraining);
    }

    @PostMapping("/{id}/after")
    @Operation(summary = "Create after_training impression")
    public AfterTraining createAfterTraining(@PathVariable Long id, @RequestBody AfterTraining afterTraining) {
        return trainingService.saveAfterTraining(afterTraining);
    }

    @GetMapping("/{id}/after")
    @Operation(summary = "Get all after_training impressions by training_id")
    public List<AfterTraining> getAfterTrainingsByTrainingId(@PathVariable Long id) {
        return trainingService.getAllAfterTrainingByTrainingId(id);
    }

}

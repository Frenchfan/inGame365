package com.example.ingame365.service;

import com.example.ingame365.domain.entities.training.AfterTraining;
import com.example.ingame365.domain.entities.training.BeforeTraining;
import com.example.ingame365.domain.entities.training.Training;
import com.example.ingame365.web.dto.training.TrainingDto;
import com.example.ingame365.web.dto.training.TrainingPostDto;

import java.util.List;

public interface TrainingService {

    Training getById(Long id);

    Training update(Training training);

    Training save(Training training);

    BeforeTraining save(BeforeTraining beforeTraining);

    AfterTraining saveAfterTraining(AfterTraining afterTraining);


    void deleteById(Long id);

    List<TrainingDto> getAllTrainingsByUserId(Long userId);

    List<BeforeTraining> getAllBeforeTrainingByTrainingId(Long trainingId);

    List<AfterTraining> getAllAfterTrainingByTrainingId(Long trainingId);
}

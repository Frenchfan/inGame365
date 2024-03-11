package com.example.ingame365.service.impl;

import com.example.ingame365.domain.entities.team.Team;
import com.example.ingame365.domain.entities.training.AfterTraining;
import com.example.ingame365.domain.entities.training.BeforeTraining;
import com.example.ingame365.domain.entities.training.Training;
import com.example.ingame365.repository.AfterTrainingRepository;
import com.example.ingame365.repository.BeforeTrainingRepository;
import com.example.ingame365.repository.TrainingRepository;
import com.example.ingame365.service.TrainingService;
import com.example.ingame365.web.dto.training.TrainingDto;
import com.example.ingame365.web.dto.training.TrainingPostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TrainingServiceImpl implements TrainingService {

    private final TrainingRepository trainingRepository;

    private final BeforeTrainingRepository beforeTrainingRepository;

    private final AfterTrainingRepository afterTrainingRepository;

    @Override
    public Training getById(Long id) {
        return trainingRepository.findById(id).orElse(null);
    }

    @Override
    public Training update(Training training) {
        return null;
    }

    @Override
    public Training save(Training training) {
        return trainingRepository.save(training);
    }

    @Override
    public BeforeTraining save(BeforeTraining beforeTraining) {
        return beforeTrainingRepository.save(beforeTraining);
    }

    @Override
    public AfterTraining saveAfterTraining(AfterTraining afterTraining) {
        return afterTrainingRepository.save(afterTraining);
    }

    @Override
    public void deleteById(Long id) {
        trainingRepository.deleteById(id);
    }

    @Override
    public List<TrainingDto> getAllTrainingsByUserId(Long userId) {
        return trainingRepository.findAllTrainingsByUserId(userId);
    }

    @Override
    public List<BeforeTraining> getAllBeforeTrainingByTrainingId(Long trainingId) {
        return beforeTrainingRepository.findAllByTrainingId(trainingId);
    }

    @Override
    public List<AfterTraining> getAllAfterTrainingByTrainingId(Long trainingId) {
        return afterTrainingRepository.findAllByTrainingId(trainingId);
    }
}

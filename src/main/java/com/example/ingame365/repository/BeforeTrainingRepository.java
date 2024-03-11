package com.example.ingame365.repository;

import com.example.ingame365.domain.entities.training.BeforeTraining;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BeforeTrainingRepository extends JpaRepository<BeforeTraining, Long>,
        PagingAndSortingRepository<BeforeTraining, Long> {

    List<BeforeTraining> findAllByTrainingId(Long trainingId);
}

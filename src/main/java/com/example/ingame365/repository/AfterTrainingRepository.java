package com.example.ingame365.repository;

import com.example.ingame365.domain.entities.training.AfterTraining;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface AfterTrainingRepository extends JpaRepository<AfterTraining, Long>,
        PagingAndSortingRepository<AfterTraining, Long> {

    List<AfterTraining> findAllByTrainingId(Long trainingId);
}

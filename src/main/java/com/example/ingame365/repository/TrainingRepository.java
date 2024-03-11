package com.example.ingame365.repository;

import com.example.ingame365.domain.entities.training.AfterTraining;
import com.example.ingame365.domain.entities.training.BeforeTraining;
import com.example.ingame365.domain.entities.training.Training;
import com.example.ingame365.web.dto.training.TrainingDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Long>, PagingAndSortingRepository<Training, Long> {

    @Query(value = """
            SELECT
                t.id,
                t.description,
                t.scheduled_at as scheduledAt,
                te.id as teamId,
                te.name as teamName
                FROM ingame365.training t
                              JOIN ingame365.training_teams tt
                                   ON t.id = tt.training_id
                              JOIN ingame365.users_teams ut
                                   ON tt.team_id = ut.team_id
                              JOIN ingame365.teams te
                                   ON tt.team_id = te.id
            WHERE ut.user_id = :userId
                         """, nativeQuery = true)
    List<TrainingDto> findAllTrainingsByUserId(Long userId);

}
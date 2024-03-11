package com.example.ingame365.repository;

import com.example.ingame365.domain.entities.team.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long>, PagingAndSortingRepository<Team, Long> {

    @Query(value = """
             SELECT t.id          as team_id,
                   t.name        as team_name,
                   t.logo        as team_logo,
                   t.created_at  as team_created_at,
                   t.updated_at  as team_updated_at
            FROM teams t
            JOIN users_teams ut on t.id = ut.team_id
            WHERE ut.user_id = :userId            
            """, nativeQuery = true)
    List<Team> findAllByUserId(Long userId);
    @Query(value = """
             INSERT INTO ingame365.users_teams (user_id, team_id)
            VALUES (:userId, :teamId)
            """, nativeQuery = true)
    void assignToUserById(Long teamId, Long userId);
}

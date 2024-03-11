package com.example.ingame365.domain.entities.training;

import com.example.ingame365.domain.entities.team.Team;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "training")
@Data
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private String description;
    @Column(name = "scheduled_at")
    private Timestamp scheduledAt;
//    @OneToMany
//    @JoinTable(
//            name = "training_teams",
//            joinColumns = @JoinColumn(name = "training_id"),
//            inverseJoinColumns = @JoinColumn(name = "team_id")
//    )
//    private Set<Team> teams;
}

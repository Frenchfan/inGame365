package com.example.ingame365.service.impl;

import com.example.ingame365.domain.exception.ResourceNotFoundException;
import com.example.ingame365.domain.entities.team.Team;
import com.example.ingame365.repository.TeamRepository;
import com.example.ingame365.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    @Override
    @Transactional(readOnly = true)
    public Team getById(Long id) {
        return teamRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("Team not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Team> getAllByUserId(Long userId) {
        return teamRepository.findAllByUserId(userId);
    }

    @Override
    @Transactional
    public Team update(Team team) {
        Team existingTeam = teamRepository.findById(team.getId())
                .orElseThrow(() -> new ResourceNotFoundException
                        ("Team not found"));
        teamRepository.save(team);
        return team;
    }

    @Override
    @Transactional
    public Team create(Team team) {
        teamRepository.save(team);
        return team;
    }

    @Override
    @Transactional
    public Team assignToUser(Long teamId, Long userId) {
        teamRepository.assignToUserById(teamId, userId);
        return getById(teamId);
    }

    @Override
    public void delete(Long id) {
        teamRepository.deleteById(id);
    }
}

package com.example.ingame365.service;

import com.example.ingame365.domain.entities.user.User;

import java.util.List;

public interface UserService {

    User getById(Long id);
    User getByUsername(String username);
    User update(User user);
    User create(User user);
    boolean isTaskOwner(Long userId, Long taskId);

    void delete(Long id);

    List<User> getAll(int page, int size, String sort);

    List<User> getAllByTeam(Long teamId, int page, int size, String sort);
}

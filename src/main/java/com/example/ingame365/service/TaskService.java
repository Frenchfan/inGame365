package com.example.ingame365.service;

import com.example.ingame365.domain.entities.task.Task;

import java.util.List;

public interface TaskService {

    Task getById(Long id);
    List<Task> getAllByUserId(Long userId);
    Task update(Task task);
    Task create(Task task, Long userId);
    void delete(Long id);
}

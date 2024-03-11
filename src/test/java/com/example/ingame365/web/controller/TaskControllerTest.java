package com.example.ingame365.web.controller;

import com.example.ingame365.domain.entities.task.Task;
import com.example.ingame365.service.TaskService;
import com.example.ingame365.web.dto.task.TaskDto;
import com.example.ingame365.web.mappers.TaskMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class TaskControllerTest {

    @InjectMocks
    private TaskController taskController;

    @Mock
    private TaskService taskService;

    @Mock
    private TaskMapper taskMapper;

    @Test
    public void testUpdate() {
        // Arrange
        TaskDto inputDto = new TaskDto();
        Task expectedTask = taskMapper.toEntity(inputDto);
        Mockito.when(taskService.update(Mockito.any(Task.class))).thenReturn(expectedTask);
        Mockito.when(taskMapper.toDto(expectedTask)).thenReturn(inputDto);

        // Act
        TaskDto result = taskController.update(inputDto);

        // Assert
        Assert.assertEquals(inputDto, result);
        Mockito.verify(taskService, Mockito.times(1)).update(expectedTask);
        Mockito.verify(taskMapper, Mockito.times(1)).toDto(expectedTask);
    }

    @Test
    public void testGetById() {
        // Arrange
        Long taskId = 1L;
        Task expectedTask = new Task(/* provide necessary fields */);
        TaskDto expectedDto = taskMapper.toDto(expectedTask);
        Mockito.when(taskService.getById(taskId)).thenReturn(expectedTask);
        Mockito.when(taskMapper.toDto(expectedTask)).thenReturn(expectedDto);

        // Act
        TaskDto result = taskController.getById(taskId);

        // Assert
        Assert.assertEquals(expectedDto, result);
        Mockito.verify(taskService, Mockito.times(1)).getById(taskId);
        Mockito.verify(taskMapper, Mockito.times(1)).toDto(expectedTask);
    }

    @Test
    public void testDeleteById() {
        // Arrange
        Long taskId = 1L;

        // Act
        taskController.deleteById(taskId);

        // Assert
        Mockito.verify(taskService, Mockito.times(1)).delete(taskId);
    }
}
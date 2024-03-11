package com.example.ingame365.web.mappers;

import com.example.ingame365.domain.entities.task.Task;
import com.example.ingame365.web.dto.task.TaskDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskDto toDto(Task task);
    List<TaskDto> toDto(List<Task> tasks);

    Task toEntity(TaskDto dto);
}

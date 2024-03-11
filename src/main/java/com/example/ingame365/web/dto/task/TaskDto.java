package com.example.ingame365.web.dto.task;

import com.example.ingame365.domain.entities.task.Status;
import com.example.ingame365.web.dto.validation.OnCreate;
import com.example.ingame365.web.dto.validation.OnUpdate;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class TaskDto {
    @NotNull(message = "id cannot be null", groups = OnUpdate.class)
    private Long id;
    @NotNull(message = "title cannot be null", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "title cannot be longer than 255 characters", groups = {OnCreate.class, OnUpdate.class})
    private String title;
    @Length(max = 255, message = "description cannot be longer than 255 characters", groups = {OnCreate.class, OnUpdate.class})
    private String description;
    private Status status;
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime expirationDate;
}

package com.example.ingame365.web.dto.training;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class TrainingPostDto {
    private String description;
    private Timestamp scheduledAt;
}

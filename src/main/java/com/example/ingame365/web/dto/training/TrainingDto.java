package com.example.ingame365.web.dto.training;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

public interface TrainingDto {
     Long getId();
     String getDescription();
     @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
     Timestamp getScheduledAt();

     Long getTeamId();

     String getTeamName();
}

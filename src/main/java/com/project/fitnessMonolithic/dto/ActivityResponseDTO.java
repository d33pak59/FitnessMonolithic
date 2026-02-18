package com.project.fitnessMonolithic.dto;
import com.project.fitnessMonolithic.model.ActivityType;
import com.project.fitnessMonolithic.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Builder
@Data
@AllArgsConstructor
public class ActivityResponseDTO {
    private ActivityType type;
    private Integer duration;
    private Integer caloriesBurned;
    private LocalDateTime startTime;
    private User user;
    private Map<String,Object> additionalMatrix;
}

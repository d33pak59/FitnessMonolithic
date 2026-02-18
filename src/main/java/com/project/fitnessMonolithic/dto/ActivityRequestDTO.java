package com.project.fitnessMonolithic.dto;
import com.project.fitnessMonolithic.model.ActivityType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class ActivityRequestDTO {
    private ActivityType type;
    private Integer duration;
    private Integer caloriesBurned;
    private LocalDateTime startTime;
    @NonNull
    private Long userInfo;
}

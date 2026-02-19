package com.project.fitnessMonolithic.dto;
import com.project.fitnessMonolithic.model.ActivityType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Builder
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class RecommendationRequestDTO {
    private Long activityId;
    private Long userId;
    private ActivityType type;
    private String recommendation;
    private List<String> improvements;
    private List<String> suggestions;
    private List<String> safety;
}

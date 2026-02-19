package com.project.fitnessMonolithic.controller;
import com.project.fitnessMonolithic.dto.RecommendationRequestDTO;
import com.project.fitnessMonolithic.dto.RecommendationResponseDTO;
import com.project.fitnessMonolithic.model.Recommendation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/recommendation")
public class RecommendationController {
    private final RecommendationService recommendationService;

    @PostMapping("/generate")
    public ResponseEntity<RecommendationResponseDTO> generateRecommendation(@RequestBody RecommendationRequestDTO requestDTO ){
      return ResponseEntity.ok(recommendationService.generateRecommendation(requestDTO));
    }

    @GetMapping("/user")
    public List<RecommendationResponseDTO> getUserRecommendation(@RequestHeader("X-User-Id") Long userId){
    return recommendationService.getUserRecommendation(userId);
    }


    @GetMapping("/activity")
    public List<RecommendationResponseDTO>  getActivityRecommendation(@RequestHeader("X-Activity-Id") Long activityId){
        return recommendationService.getActivityRecommendation(activityId);
    }

}

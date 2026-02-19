package com.project.fitnessMonolithic.service;
import com.project.fitnessMonolithic.dto.RecommendationRequestDTO;
import com.project.fitnessMonolithic.dto.RecommendationResponseDTO;
import com.project.fitnessMonolithic.model.Activity;
import com.project.fitnessMonolithic.model.Recommendation;
import com.project.fitnessMonolithic.model.User;
import com.project.fitnessMonolithic.repository.ActivityRepository;
import com.project.fitnessMonolithic.repository.RecommendationRepository;
import com.project.fitnessMonolithic.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendationService {

    private final RecommendationRepository recommendationRepository;
    private final ActivityRepository activityRepository;
    private final UserRepository userRepository;
    public RecommendationResponseDTO generateRecommendation(RecommendationRequestDTO requestDTO) {

        Activity savedActivity = activityRepository.findById(requestDTO.getActivityId())
                .orElseThrow(() -> new RuntimeException("Activity Not Found"));

        User savedUser = userRepository.findById(requestDTO.getUserId()).orElseThrow(()->new RuntimeException("User Not Found"));

        Recommendation recommendation = Recommendation.builder()
                .recommendation(requestDTO.getRecommendation())
                .type(requestDTO.getType())
                .safety(requestDTO.getSafety())
                .suggestions(requestDTO.getSuggestions())
                .improvements(requestDTO.getImprovements())
                .activity(savedActivity)
                .user(savedUser)
                .build();

        Recommendation savedRecommendation = recommendationRepository.save(recommendation);

        return RecommendationResponseDTO.builder()
                .recommendation(savedRecommendation.getRecommendation())
                .type(savedRecommendation.getType())
                .safety(savedRecommendation.getSafety())
                .suggestions(savedRecommendation.getSuggestions())
                .improvements(savedRecommendation.getImprovements())
                .build();
    }


    public List<RecommendationResponseDTO> getUserRecommendation(Long userId) {
        List<RecommendationResponseDTO> recommendationResponseDTOList = new ArrayList<>();
        List<Recommendation>recommendations= recommendationRepository.findByUserId(userId);
        recommendations.stream().forEach(recommendation -> {
            RecommendationResponseDTO responseDTO=RecommendationResponseDTO.builder()
                    .recommendation(recommendation.getRecommendation())
                    .type(recommendation.getType())
                    .safety(recommendation.getSafety())
                    .suggestions(recommendation.getSuggestions())
                    .improvements(recommendation.getImprovements())
                    .build();
            recommendationResponseDTOList.add(responseDTO);
        });
                return recommendationResponseDTOList;
    }

    public List<RecommendationResponseDTO> getActivityRecommendation(Long activityId) {
        List<RecommendationResponseDTO> recommendationResponseDTOList = new ArrayList<>();
        List<Recommendation> recommendations=recommendationRepository.findByActivityId(activityId);
        recommendations.forEach(recommendation -> {
           RecommendationResponseDTO responseDTO=RecommendationResponseDTO.builder()
                   .recommendation(recommendation.getRecommendation())
                   .type(recommendation.getType())
                   .safety(recommendation.getSafety())
                   .suggestions(recommendation.getSuggestions())
                   .improvements(recommendation.getImprovements())
                   .build();
           recommendationResponseDTOList.add(responseDTO);
        });
        return recommendationResponseDTOList;
    }
}

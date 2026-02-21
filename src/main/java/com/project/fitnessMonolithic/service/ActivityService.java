package com.project.fitnessMonolithic.service;
import com.project.fitnessMonolithic.dto.ActivityRequestDTO;
import com.project.fitnessMonolithic.dto.ActivityResponseDTO;
import com.project.fitnessMonolithic.model.Activity;
import com.project.fitnessMonolithic.model.User;
import com.project.fitnessMonolithic.repository.ActivityRepository;
import com.project.fitnessMonolithic.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ActivityService {
    private final ActivityRepository activityRepository;
    private final UserRepository userRepository;

    public ActivityResponseDTO registerActivity(ActivityRequestDTO activityRequestDTO) {
        User savedUser = userRepository.findById(activityRequestDTO.getUserInfo()).orElseThrow(() -> new RuntimeException("User not found"));

        Activity activity = Activity.builder()
                .type(activityRequestDTO.getType())
                .userInfo(savedUser.getId())
                .duration(activityRequestDTO.getDuration())
                .caloriesBurned(activityRequestDTO.getCaloriesBurned())
                .startTime(activityRequestDTO.getStartTime())
                .user(savedUser)
                .additionalMatrix(activityRequestDTO.getAdditionalMatrix())
                .build();

        activityRepository.save(activity);

     return  ActivityResponseDTO.builder()
                .type(activityRequestDTO.getType())
                .duration(activityRequestDTO.getDuration())
                .caloriesBurned(activityRequestDTO.getCaloriesBurned()).startTime(activityRequestDTO.getStartTime())
             .user(savedUser)
             .additionalMatrix(activityRequestDTO.getAdditionalMatrix())
                .build();

    }

    public ActivityResponseDTO getActivityById(Long id) {
        Activity activity = activityRepository.findById(id).orElseThrow();
        return ActivityResponseDTO.builder()
                .type(activity.getType())
                .duration(activity.getDuration())
                .caloriesBurned(activity.getCaloriesBurned())
                .startTime(activity.getStartTime())
                .user(activity.getUser())
                .additionalMatrix(activity.getAdditionalMatrix())
                .build();
    }

    public List<Activity> getActivitiesByUserId(@RequestHeader Long userId) {
    List<Activity>activities=activityRepository.findByUserInfo(userId);
    return activities;
    }
}

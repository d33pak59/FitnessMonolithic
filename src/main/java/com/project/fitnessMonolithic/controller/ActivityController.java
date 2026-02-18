package com.project.fitnessMonolithic.controller;
import com.project.fitnessMonolithic.dto.ActivityRequestDTO;
import com.project.fitnessMonolithic.dto.ActivityResponseDTO;
import com.project.fitnessMonolithic.model.Activity;
import com.project.fitnessMonolithic.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/activity")
public class ActivityController {
    private final ActivityService activityService;

    @PostMapping()
    public ResponseEntity<ActivityResponseDTO> registerActivity(@RequestBody ActivityRequestDTO activityRequestDTO) {
        return ResponseEntity.ok(activityService.registerActivity(activityRequestDTO));
    }

    @GetMapping("/{id}")
    public ActivityResponseDTO getActivityById(@PathVariable Long id) {
       return  activityService.getActivityById(id);
    }

    @GetMapping
    public List<Activity> getActivitiesByUserId(@RequestHeader("X-User-Id") Long userId) {
        return activityService.getActivitiesByUserId(userId);
    }

}

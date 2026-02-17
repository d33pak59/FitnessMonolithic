package com.project.fitnessMonolithic.model;

import jdk.jfr.Enabled;

import java.time.LocalDateTime;

@Enabled
public class Activities {
    private Long id;
    private Long calories_burned;
    private LocalDateTime created_at;
    
}

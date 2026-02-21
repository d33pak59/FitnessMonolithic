package com.project.fitnessMonolithic.dto;

import com.project.fitnessMonolithic.model.Activity;
import com.project.fitnessMonolithic.model.Actors;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterResponseDTO {
    private String message;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Actors role;
}

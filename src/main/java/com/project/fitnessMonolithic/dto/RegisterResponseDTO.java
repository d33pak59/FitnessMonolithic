package com.project.fitnessMonolithic.dto;

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
}

package com.project.fitnessMonolithic.dto;
import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequestDTO {
    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
}

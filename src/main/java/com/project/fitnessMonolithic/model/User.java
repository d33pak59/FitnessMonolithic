package com.project.fitnessMonolithic.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private String email;
    private String first_name;
    private String last_name;
    private String password;
    private Enum role;

}

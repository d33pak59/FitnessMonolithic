package com.project.fitnessMonolithic.controller;

import com.project.fitnessMonolithic.dto.RegisterRequestDTO;
import com.project.fitnessMonolithic.dto.RegisterResponseDTO;
import com.project.fitnessMonolithic.dto.UserResponseDTO;
import com.project.fitnessMonolithic.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDTO> register(@RequestBody RegisterRequestDTO requestDTO) {
        return ResponseEntity.ok(authService.register(requestDTO));
    }

    @GetMapping("/get/{id}")
    public UserResponseDTO getUser(@PathVariable Long  id) {
     return  authService.getUser(id);
    }
}

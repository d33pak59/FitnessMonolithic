package com.project.fitnessMonolithic.controller;

import com.project.fitnessMonolithic.dto.RegisterRequestDTO;
import com.project.fitnessMonolithic.dto.UserResponseDTO;
import com.project.fitnessMonolithic.model.User;
import com.project.fitnessMonolithic.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<RegisterRequestDTO> register(@RequestBody RegisterRequestDTO requestDTO) {
        return ResponseEntity.ok(userService.register(requestDTO));
    }

    @GetMapping("/get/{id}")
    public UserResponseDTO getUser(@PathVariable Long  id) {
     return  userService.getUser(id);
    }
}

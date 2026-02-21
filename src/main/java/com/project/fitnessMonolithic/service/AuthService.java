package com.project.fitnessMonolithic.service;

import com.project.fitnessMonolithic.dto.RegisterRequestDTO;
import com.project.fitnessMonolithic.dto.RegisterResponseDTO;
import com.project.fitnessMonolithic.dto.UserResponseDTO;
import com.project.fitnessMonolithic.model.User;
import com.project.fitnessMonolithic.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public  RegisterResponseDTO register(RegisterRequestDTO requestDTO) {
        User user = User.builder()
                .firstName(requestDTO.getFirstName())
                .lastName(requestDTO.getLastName())
                .email(requestDTO.getEmail())
                .role(requestDTO.getRole())
                .password(passwordEncoder.encode(requestDTO.getPassword()))
                .build();
         User savedUser= userRepository.save(user);
          return  RegisterResponseDTO.builder()
                  .message("User registered successfully!")
                  .firstName(savedUser.getFirstName())
                  .lastName(savedUser.getLastName())
                  .email(savedUser.getEmail())
                  .role(savedUser.getRole())
                  .password(savedUser.getPassword())
                  .build();
    }

    public UserResponseDTO getUser(Long id) {
        User savedUser=userRepository.findById(id).orElseThrow();
        return  UserResponseDTO.builder()
                .id(savedUser.getId())
                .firstName(savedUser.getFirstName())
                .lastName(savedUser.getLastName())
                .email(savedUser.getEmail())
                .build();

    }
}

package com.project.fitnessMonolithic.service;

import com.project.fitnessMonolithic.dto.RegisterRequestDTO;
import com.project.fitnessMonolithic.dto.UserResponseDTO;
import com.project.fitnessMonolithic.model.User;
import com.project.fitnessMonolithic.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public  RegisterRequestDTO register(RegisterRequestDTO requestDTO) {
        User user = User.builder()
                .firstName(requestDTO.getFirstName())
                .lastName(requestDTO.getLastName())
                .email(requestDTO.getEmail())
                .password(requestDTO.getPassword())
                .build();
          userRepository.save(user);
          return requestDTO;
    }

    public UserResponseDTO getUser(Long id) {
        User savedUser=userRepository.findById(id).orElseThrow();
        return  UserResponseDTO.builder()
                .id(savedUser.getId())
                .firstName(savedUser.getFirstName())
                .lastName(savedUser.getLastName())
                .email(savedUser.getEmail())
                .password(savedUser.getPassword())
                .build();

    }
}

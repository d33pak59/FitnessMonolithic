package com.project.fitnessMonolithic.security;

import com.project.fitnessMonolithic.dto.LoginRequestDTO;
import com.project.fitnessMonolithic.dto.LoginResponseDTO;
import com.project.fitnessMonolithic.model.User;
import com.project.fitnessMonolithic.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final UserRepository userRepository;
    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDTO.getUsername(), loginRequestDTO.getPassword())
        );

       User user=(User)authentication.getPrincipal();

        return LoginResponseDTO.builder()
                .jwtToken(jwtUtils.generateAccessToken(user))
                .id(user.getId())
                .build();
    }
}

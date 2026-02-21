package com.project.fitnessMonolithic.security;
import com.project.fitnessMonolithic.dto.LoginRequestDTO;
import com.project.fitnessMonolithic.dto.LoginResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        return ResponseEntity.ok(loginService.login(loginRequestDTO));
    }
}

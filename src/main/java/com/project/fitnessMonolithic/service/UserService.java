package com.project.fitnessMonolithic.service;

import com.project.fitnessMonolithic.model.User;
import com.project.fitnessMonolithic.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public User register(User user) {
       return  userRepository.save(user);
    }
}

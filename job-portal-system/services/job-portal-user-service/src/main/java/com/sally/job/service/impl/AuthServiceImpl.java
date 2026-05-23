package com.sally.job.service.impl;

import com.sally.job.domain.UserRole;
import com.sally.job.mapper.UserMapper;
import com.sally.job.modal.User;
import com.sally.job.payload.AuthResponse;
import com.sally.job.payload.LoginRequest;
import com.sally.job.payload.SignupRequest;
import com.sally.job.repository.UserRepository;
import com.sally.job.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    @Override
    public AuthResponse signup(SignupRequest req) throws Exception {
        if (userRepository.findByEmail(req.getEmail()) != null) {
            throw new Exception("Email Already registered : " + req.getEmail());
        }

        if (req.getRole() == UserRole.ROLE_ADMIN) {
            throw new Exception("cannot self-register as role admin");
        }

        User user = User.builder()
                .fullName(req.getFullName())
                .email(req.getEmail())
                .password(req.getPassword())
                .role(req.getRole())
                .phone(req.getPhone())
                .lastLogin(LocalDateTime.now())
                .build();

        User savedUser = userRepository.save(user);

        AuthResponse res = new AuthResponse();
        res.setTitle("welcome " + savedUser.getFullName());
        res.setMessage("Registered successfully");
        res.setJwt("jwt");
        res.setUser(UserMapper.toDTO(savedUser));

        return res;
    }

    @Override
    public AuthResponse signin(LoginRequest req) {
        return null;
    }
}

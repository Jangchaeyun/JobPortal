package com.sally.job.service.impl;

import com.sally.job.domain.UserRole;
import com.sally.job.domain.UserStatus;
import com.sally.job.mapper.UserMapper;
import com.sally.job.modal.User;
import com.sally.job.payload.AuthResponse;
import com.sally.job.payload.LoginRequest;
import com.sally.job.payload.SignupRequest;
import com.sally.job.repository.UserRepository;
import com.sally.job.security.JwtProvider;
import com.sally.job.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

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
                .password(passwordEncoder.encode(req.getPassword()))
                .role(req.getRole())
                .phone(req.getPhone())
                .lastLogin(LocalDateTime.now())
                .status(UserStatus.ACTIVE)
                .build();

        User savedUser = userRepository.save(user);

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                user.getEmail(), user.getPassword()
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateToken(authentication, savedUser.getId());

        AuthResponse res = new AuthResponse();
        res.setTitle("welcome " + savedUser.getFullName());
        res.setMessage("Registered successfully");
        res.setJwt(jwt);
        res.setUser(UserMapper.toDTO(savedUser));

        return res;
    }

    @Override
    public AuthResponse signin(LoginRequest req) {
        return null;
    }
}

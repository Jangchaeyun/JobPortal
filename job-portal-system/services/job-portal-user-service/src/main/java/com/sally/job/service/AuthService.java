package com.sally.job.service;

import com.sally.job.payload.AuthResponse;
import com.sally.job.payload.LoginRequest;
import com.sally.job.payload.SignupRequest;

public interface AuthService {
    AuthResponse signup(SignupRequest req) throws Exception;
    AuthResponse signin(LoginRequest req);
}

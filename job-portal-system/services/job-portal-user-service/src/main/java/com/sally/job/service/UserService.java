package com.sally.job.service;

import com.sally.job.dto.response.UserResponse;
import com.sally.job.modal.User;
import com.sally.job.payload.UpdateUserRequest;

import java.util.List;

public class UserService {
    User getUserByEmail(String email);

    User getUserById(Long id);

    List<User> getAllUsers();

    UserResponse updateProfile(String email, UpdateUserRequest req);
}

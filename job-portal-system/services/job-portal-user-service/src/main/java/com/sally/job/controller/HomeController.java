package com.sally.job.controller;

import com.sally.job.domain.UserRole;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping
    public String HomeContoller() {
        return "Job Portal User Service ----------- " + UserRole.ROLE_JOB_SEEKER;
    }
}

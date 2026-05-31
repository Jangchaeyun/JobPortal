package com.sally.job.service;

import com.sally.job.dto.CompanyRequest;
import com.sally.job.dto.CompanyResponse;

public interface CompanyService {
    CompanyResponse createCompany(Long ownerId, CompanyRequest req);
}

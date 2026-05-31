package com.sally.job.dto;

import com.sally.job.domain.CompanySize;
import com.sally.job.domain.CompanyStatus;
import com.sally.job.domain.CompanyType;
import com.sally.job.domain.IndustryType;

import java.time.LocalDateTime;
import java.util.List;

public class CompanyResponse {

    private Long id;
    private String name;
    private String slug;
    private String tagline;
    private String description;
    private String logoUrl;
    private String coverImageUrl;
    private String website;
    private String email;
    private String phone;
    private Integer foundedYear;

    private CompanySize companySize;
    private CompanyType companyType;
    private IndustryType industryType;
    private CompanyStatus status;
    private Boolean verified;
    private Boolean active;

    private Long ownerId;

    private List<SocialLinkResponse> socialLinks;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime verifiedAt;
}
package com.sally.job.dto;

import com.sally.job.domain.CompanySize;
import com.sally.job.domain.CompanyType;
import com.sally.job.domain.IndustryType;
import jakarta.validation.constraints.*;

import java.util.List;

public class CompanyRequest {
    @NotBlank(message = "company name is required")
    private String name;

    private String tagLine;

    private String description;

    private String logoUrl;
    private String coverImageUrl;

    @Pattern(regexp = "^(https?://).*", message = "Website must be a valid URL")
    private String website;

    @Email(message = "Company email must be valid")
    private String email;

    private String phone;

    @Min(value = 1000, message = "Founded year seems too old")
    @Max(value = 2100, message = "Founded year is invalid")
    private Integer foundedYear;

    @NotNull(message = "Company size is required")
    private CompanySize companySize;

    @NotNull(message = "Company type is required")
    private CompanyType companyType;

    @NotNull(message = "Industry type is required")
    private IndustryType industryType;

    private String registerationNumber;

    private List<SocialLinkResponse> socialLinks;
}

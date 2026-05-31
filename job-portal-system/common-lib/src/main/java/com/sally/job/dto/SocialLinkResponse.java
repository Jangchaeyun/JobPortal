package com.sally.job.dto;

import com.sally.job.domain.SocialPlatform;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SocialLinkResponse {
    private SocialPlatform platform;
    private String url;
}

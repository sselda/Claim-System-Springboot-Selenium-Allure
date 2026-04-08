package com.insurance.claimsystem.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ClaimResponseDTO {

    private Long id;
    private String description;
    private Double amount;
    private String status;
    private Boolean fraudFlag;
    private LocalDateTime createdAt;
}

package com.insurance.claimsystem.mapper;

import com.insurance.claimsystem.dto.ClaimRequestDTO;
import com.insurance.claimsystem.dto.ClaimResponseDTO;
import com.insurance.claimsystem.entity.Claim;
import com.insurance.claimsystem.entity.ClaimStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ClaimMapper {

    //Entity -> DTO
    public Claim toEntity(ClaimRequestDTO dto) {
        return Claim.builder()
                .description(dto.getDescription())
                .amount(dto.getAmount())
                .status(ClaimStatus.NEW)
                .fraudFlag(false)
                .createdAt(LocalDateTime.now())
                .build();
    }

    //DTO -> Entity
    public ClaimResponseDTO toResponse(Claim claim) {
        return ClaimResponseDTO.builder()
                .id(claim.getId())
                .description(claim.getDescription())
                .amount(claim.getAmount())
                .status(claim.getStatus().name())
                .fraudFlag(claim.getFraudFlag())
                .createdAt(claim.getCreatedAt())
                .build();
    }
}

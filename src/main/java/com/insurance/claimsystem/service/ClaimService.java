package com.insurance.claimsystem.service;

import com.insurance.claimsystem.dto.ClaimRequestDTO;
import com.insurance.claimsystem.dto.ClaimResponseDTO;
import com.insurance.claimsystem.entity.Claim;
import com.insurance.claimsystem.entity.ClaimStatus;
import com.insurance.claimsystem.jdbc.ClaimJdbcRepository;
import com.insurance.claimsystem.mapper.ClaimMapper;
import com.insurance.claimsystem.repository.ClaimRepository;
import org.springframework.stereotype.Service;

@Service
public class ClaimService {

    private final ClaimRepository claimRepository;
    private final ClaimJdbcRepository claimJdbcRepository;
    private final ClaimMapper claimMapper;

    public ClaimService(ClaimRepository claimRepository,
                        ClaimJdbcRepository claimJdbcRepository,
                        ClaimMapper claimMapper) {
        this.claimRepository = claimRepository;
        this.claimJdbcRepository = claimJdbcRepository;
        this.claimMapper = claimMapper;

    }

    public ClaimResponseDTO createClaim(ClaimRequestDTO request) {

        Claim claim = claimMapper.toEntity(request);

        //Standart CRUD(save, find)
        Claim savedClaim = claimRepository.save(claim);

        //Store Procedure
    claimJdbcRepository.processClaim(savedClaim.getId());

    Claim updated = claimRepository.findById(savedClaim.getId()).orElseThrow();

    return claimMapper.toResponse(updated);
    }

    public ClaimResponseDTO approveClaim(Long id) {
        Claim claim = claimRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Claim not found"));

        //Business Rule
        if(claim.getStatus() != ClaimStatus.NEW) {
            throw new IllegalStateException("Only NEW claims can be approved");
        }

        claim.setStatus(ClaimStatus.APPROVED);
        Claim saved = claimRepository.save(claim);
        return claimMapper.toResponse(saved);
    }

    public ClaimResponseDTO rejectedClaim(Long id) {
        Claim claim = claimRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Claim is rejected"));

        if(claim.getStatus() != ClaimStatus.REVIEW) {
            throw new IllegalStateException("Only REVIEW can be rejected");
        }

        claim.setStatus(ClaimStatus.REJECTED);
        Claim saved = claimRepository.save(claim);
        return claimMapper.toResponse(saved);

    }



}

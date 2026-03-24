package com.insurance.claimsystem.service;

import com.insurance.claimsystem.entity.Claim;
import com.insurance.claimsystem.entity.ClaimStatus;
import com.insurance.claimsystem.jdbc.ClaimJdbcRepository;
import com.insurance.claimsystem.repository.ClaimRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ClaimService {

    private final ClaimRepository claimRepository;
    private final ClaimJdbcRepository claimJdbcRepository;

    public ClaimService(ClaimRepository claimRepository,
                        ClaimJdbcRepository claimJdbcRepository) {
        this.claimRepository = claimRepository;
        this.claimJdbcRepository = claimJdbcRepository;
    }

    public Claim createClaim(String description, Double amount, Boolean fraudFlag) {

        Claim claim = Claim.builder()
                .description(description)
                .amount(amount)
                .fraudFlag(fraudFlag)
                .status(ClaimStatus.APPROVED)
                .createdAt(LocalDateTime.now())
                .build();

        Claim savedClaim = claimRepository.save(claim);

    claimJdbcRepository.processClaim(savedClaim.getId());

    return claimRepository.findById(savedClaim.getId()).orElseThrow();

    }
}

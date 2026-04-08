package com.insurance.claimsystem.controller;

import com.insurance.claimsystem.dto.ClaimRequestDTO;
import com.insurance.claimsystem.dto.ClaimResponseDTO;
import com.insurance.claimsystem.entity.Claim;
import com.insurance.claimsystem.service.ClaimService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("claims")
public class ClaimController {

    private final ClaimService claimService;

    public ClaimController(ClaimService claimService) {
        this.claimService = claimService;
    }

    @PostMapping
    public ClaimResponseDTO create(@RequestBody ClaimRequestDTO request) {
        return claimService.createClaim(request);
    }

    @PutMapping("{id}/approve")
    public ClaimResponseDTO approve(@PathVariable Long id) {
        return claimService.approveClaim(id);
    }
}

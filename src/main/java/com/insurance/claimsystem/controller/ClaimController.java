package com.insurance.claimsystem.controller;

import com.insurance.claimsystem.entity.Claim;
import com.insurance.claimsystem.service.ClaimService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/claims")
public class ClaimController {

    private final ClaimService claimService;

    public ClaimController(ClaimService claimService) {
        this.claimService = claimService;
    }

    @PostMapping
    public Claim createClaim(@RequestParam String description,
                             @RequestParam Double amount,
                             @RequestParam(required = false, defaultValue = "false") Boolean fraudFlag) {

        return claimService.createClaim(description,amount,fraudFlag);
    }
}

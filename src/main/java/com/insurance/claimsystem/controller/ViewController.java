package com.insurance.claimsystem.controller;

import com.insurance.claimsystem.dto.ClaimRequestDTO;
import com.insurance.claimsystem.service.ClaimService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ViewController {

    private final ClaimService claimService;

    public ViewController(ClaimService claimService) {
        this.claimService = claimService;
    }

    @GetMapping("/claim-form")
    public String showForm() {
        return "claim-form";
    }

    @PostMapping("/claims-ui")
    @ResponseBody
    public String createClaim(
            @RequestParam String description,
            @RequestParam Double amount,
            @RequestParam(required = false) Boolean fraudFlag) {
        ClaimRequestDTO request = new ClaimRequestDTO();
        request.setDescription(description);
        request.setAmount(amount);
        claimService.createClaim(request);
        return "redirect:/claims";
    }

}

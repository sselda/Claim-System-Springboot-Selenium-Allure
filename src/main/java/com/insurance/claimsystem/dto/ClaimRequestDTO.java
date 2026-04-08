package com.insurance.claimsystem.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ClaimRequestDTO {

    @NotNull
    @Size(min = 5, max = 255)
    private String description;

    @NotNull
    private Double amount;

}

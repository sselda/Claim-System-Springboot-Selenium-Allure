package com.insurance.claimsystem.dto;

import lombok.Data;

@Data
public class ClaimUpdateDTO {

    private String description;
    private Double amount;
    private String fraudFlag;
}

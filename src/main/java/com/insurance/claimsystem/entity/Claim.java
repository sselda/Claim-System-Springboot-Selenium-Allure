package com.insurance.claimsystem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name="claims")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Double amount;

    @Enumerated(EnumType.STRING)
    private ClaimStatus status;

    @Column(name = "fraud_flag")
    private Boolean fraudFlag;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

}

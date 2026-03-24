package com.insurance.claimsystem.repository;

import com.insurance.claimsystem.entity.Claim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimRepository extends JpaRepository<Claim, Long> {



}

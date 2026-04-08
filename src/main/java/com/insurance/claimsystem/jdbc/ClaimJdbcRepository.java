package com.insurance.claimsystem.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ClaimJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    public ClaimJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void processClaim(Long claimId) {
        jdbcTemplate.update("CALL processclaim(?)", claimId);
    }
}

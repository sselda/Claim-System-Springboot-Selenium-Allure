package com.insurance.claimsystem.tests;

import com.insurance.claimsystem.base.BaseTest;
import com.insurance.claimsystem.pages.ClaimPage;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClaimUITest extends BaseTest {

    @LocalServerPort
    int port;

    @Test
    void shouldCreateClaimViaUI() {

        System.out.println("PORT: " + port);
        ClaimPage page = new ClaimPage(driver);

        page.open(port);

        page.createClaim("UI Test", "500");

        String result = page.getResult();

        System.out.println("RESULT: " + result);

        assertTrue(result.contains("UI Test"));
    }
}